package com.tencent.biz.qqcircle.fragments.chat.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.qqcircle.richframework.widget.drag.DragFrameLayout;
import com.tencent.biz.qqcircle.richframework.widget.drag.DragTextView;
import com.tencent.biz.qqcircle.utils.QCircleProtoUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import qqcircle.QQCirclePrivateMsgShow.PMGiftDisplayInfo;
import qqcircle.QQCirclePrivateMsgShow.PMGiftInfo;
import qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo;

public class QCircleChatItemView
  extends QCircleBaseWidgetView<QCircleRecentDataInterface>
{
  private QCircleAvatarView a;
  private DragTextView b;
  private TextView c;
  private TextView d;
  private SingleLineTextView e;
  private LinearLayout f;
  private DragFrameLayout g;
  
  public QCircleChatItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void b(QCircleRecentDataInterface paramQCircleRecentDataInterface, int paramInt)
  {
    for (;;)
    {
      try
      {
        paramQCircleRecentDataInterface = QCircleProtoUtil.b(paramQCircleRecentDataInterface.getGiftInfo());
        if (paramQCircleRecentDataInterface == null) {
          return;
        }
        if ((paramQCircleRecentDataInterface.giftInfos.get() != null) && (paramQCircleRecentDataInterface.giftInfos.size() > 0))
        {
          this.f.setVisibility(0);
          this.f.removeAllViews();
          int i = paramQCircleRecentDataInterface.giftInfos.size();
          paramInt = 0;
          if (paramInt < i)
          {
            Object localObject2 = (QQCirclePrivateMsgShow.PMGiftInfo)paramQCircleRecentDataInterface.giftInfos.get(paramInt);
            if ((localObject2 == null) || (((QQCirclePrivateMsgShow.PMGiftInfo)localObject2).giftCnt.get() <= 0)) {
              break label257;
            }
            localObject1 = new QCircleChatGiftRecordView(getContext());
            ((QCircleChatGiftRecordView)localObject1).setGiftCount(((QQCirclePrivateMsgShow.PMGiftInfo)localObject2).giftCnt.get(), false);
            ((QCircleChatGiftRecordView)localObject1).setIconUrl(((QQCirclePrivateMsgShow.PMGiftInfo)localObject2).display.icon.get());
            localObject2 = new LinearLayout.LayoutParams(-2, -1);
            ((LinearLayout.LayoutParams)localObject2).gravity = 17;
            if (paramInt == 0) {
              ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
            } else {
              ((LinearLayout.LayoutParams)localObject2).leftMargin = ViewUtils.a(4.0F);
            }
            this.f.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            break label257;
          }
        }
        else
        {
          this.f.setVisibility(8);
        }
        this.a.setIsAuth(paramQCircleRecentDataInterface.certification.get());
        return;
      }
      catch (Exception paramQCircleRecentDataInterface)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initGiftLayout error");
        ((StringBuilder)localObject1).append(paramQCircleRecentDataInterface.getMessage());
        QLog.d("QCircleRecentTempChatItemView", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      label257:
      paramInt += 1;
    }
  }
  
  public void a(QCircleRecentDataInterface paramQCircleRecentDataInterface, int paramInt)
  {
    if (paramQCircleRecentDataInterface != null)
    {
      this.c.setText(paramQCircleRecentDataInterface.getTitleName());
      this.d.setText(paramQCircleRecentDataInterface.getShowTime());
      this.a.setAvatarByUin(paramQCircleRecentDataInterface.getRecentUserUin());
      String str;
      if (paramQCircleRecentDataInterface.getMsgExtraInfo() != null) {
        str = paramQCircleRecentDataInterface.getMsgExtraInfo().toString();
      } else {
        str = "";
      }
      this.e.setExtendText(str, 1);
      this.e.setText(paramQCircleRecentDataInterface.getLastMsg());
      if (paramQCircleRecentDataInterface.getUnreadNum() > 0)
      {
        this.b.setVisibility(0);
        this.b.setText(HostChatUtils.getMaxUnReadCountText(paramQCircleRecentDataInterface.getUnreadNum()));
      }
      else
      {
        this.b.setVisibility(8);
      }
      this.b.setTag(Integer.valueOf(paramInt));
      b(paramQCircleRecentDataInterface, paramInt);
    }
  }
  
  public int getLayoutId()
  {
    return 2131626771;
  }
  
  protected String getLogTag()
  {
    return "QCircleRecentTempChatItemView";
  }
  
  public DragTextView getRedPointView()
  {
    return this.b;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.a = ((QCircleAvatarView)paramView.findViewById(2131436271));
      this.b = ((DragTextView)paramView.findViewById(2131448696));
      this.b.setDragViewType(0, paramView);
      this.c = ((TextView)paramView.findViewById(2131448603));
      this.d = ((TextView)paramView.findViewById(2131448805));
      this.e = ((SingleLineTextView)paramView.findViewById(2131448376));
      this.f = ((LinearLayout)paramView.findViewById(2131437464));
      this.e.setTextColor(QCircleSkinHelper.getInstance().getColor(2131167084));
    }
  }
  
  public void setDragFrameLayout(DragFrameLayout paramDragFrameLayout)
  {
    QLog.d("QCircleRecentTempChatItemView", 1, "setDragFrameLayout");
    this.g = paramDragFrameLayout;
    paramDragFrameLayout = this.b;
    if (paramDragFrameLayout != null) {
      paramDragFrameLayout.setOnModeChangeListener(this.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.chat.item.QCircleChatItemView
 * JD-Core Version:    0.7.0.1
 */