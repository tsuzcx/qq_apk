package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ReqStoryMessageList;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class MessageNotifySegment
  extends SegmentView<oidb_0x791.RedDotInfo>
  implements View.OnClickListener
{
  public static final String KEY = "MessageNotifySegment";
  private int a = 0;
  private long b;
  private String c;
  private Integer d;
  
  public MessageNotifySegment(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (this.a == 0)
    {
      paramBaseViewHolder.a(2131447419).setVisibility(8);
      paramBaseViewHolder.a().setLayoutParams(new AbsListView.LayoutParams(-1, 0));
      return paramBaseViewHolder.a();
    }
    paramInt = UIUtils.a(paramBaseViewHolder.a().getContext(), 52.0F);
    paramBaseViewHolder.a(2131447419).setVisibility(0);
    paramBaseViewHolder.a().setLayoutParams(new AbsListView.LayoutParams(-1, paramInt));
    paramBaseViewHolder.a().setVisibility(0);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131435219);
    Drawable localDrawable = ImageUtil.j();
    QQStoryContext.a();
    if (QQStoryContext.j() == null)
    {
      localImageView.setImageDrawable(localDrawable);
    }
    else
    {
      if (localImageView.getTag() != null)
      {
        paramViewGroup = this.d;
        if ((paramViewGroup == null) || (paramViewGroup.equals(localImageView.getTag()))) {
          return paramBaseViewHolder.a();
        }
      }
      localImageView.setTag(this.d);
      localImageView.setImageDrawable(localDrawable);
      TextView localTextView = (TextView)paramBaseViewHolder.a(2131431322);
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt = this.a;
      if (paramInt > 99) {
        paramViewGroup = "99+";
      } else {
        paramViewGroup = Integer.valueOf(paramInt);
      }
      localStringBuilder.append(paramViewGroup);
      localStringBuilder.append(HardCodeUtil.a(2131904526));
      localTextView.setText(localStringBuilder.toString());
      if (this.b <= 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "uin <=0. fetch first message.");
        }
        a(localImageView);
      }
      else
      {
        ThreadManager.post(new MessageNotifySegment.1(this, localImageView, localDrawable), 8, null, true);
      }
    }
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.l).inflate(2131628091, paramViewGroup, false);
    paramViewGroup.findViewById(2131447419).setOnClickListener(this);
    return new BaseViewHolder(paramViewGroup);
  }
  
  public void a(ImageView paramImageView)
  {
    qqstory_710_message.ReqStoryMessageList localReqStoryMessageList = new qqstory_710_message.ReqStoryMessageList();
    localReqStoryMessageList.num.set(1);
    localReqStoryMessageList.start_time.set(0);
    localReqStoryMessageList.source.set(0);
    localReqStoryMessageList.version_ctrl.set(775);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "fetch first message from gray, start=0");
    }
    QQStoryContext.a();
    ProtoUtils.a(QQStoryContext.j(), new MessageNotifySegment.MessageListFirstObserver(this, paramImageView), localReqStoryMessageList.toByteArray(), StoryApi.a("StorySvc.get_710_message_list"));
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if ((paramRedDotInfo != null) && (paramRedDotInfo.uint32_appid.get() == 52) && (paramRedDotInfo.bool_display_reddot.get()) && (paramRedDotInfo.uint32_number.get() > 0))
    {
      this.a = paramRedDotInfo.uint32_number.get();
      this.b = paramRedDotInfo.uint64_cmd_uin.get();
      this.d = Integer.valueOf(paramRedDotInfo.uint32_last_time.get());
      this.c = paramRedDotInfo.str_face_url.get().toStringUtf8();
      return;
    }
    this.a = 0;
  }
  
  public String b()
  {
    return "MessageNotifySegment";
  }
  
  protected void g()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.j();
    if (localQQAppInterface != null)
    {
      a(((TroopRedTouchManager)localQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).e(52));
      return;
    }
    SLog.e("Q.qqstory.home.MessageNotifySegment", "Get the QQAppInterface is null,we dont know the red point state");
  }
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.l, StoryMessageListActivity.class);
    ((Intent)localObject).putExtra("qqstory_message_list_source", 0);
    ((Intent)localObject).putExtra("qqstory_jump_source", "2");
    this.l.startActivity((Intent)localObject);
    localObject = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().i());
    int i;
    if ((localObject != null) && (((QQUserUIItem)localObject).isVip)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      i = 1;
    } else {
      i = 2;
    }
    StoryReportor.a("play_video", "clk_grey", i, 0, new String[] { "", "", "", "" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment
 * JD-Core Version:    0.7.0.1
 */