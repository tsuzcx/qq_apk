package com.tencent.biz.qqcircle.widgets;

import aauy;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import bglp;
import bgpa;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StRelationInfo;
import qqcircle.QQCircleRelation.RelationBiz;
import uxk;
import uxo;
import uxx;
import vyp;
import vyq;

public class QCircleSpecialFollowUserItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StRelationInfo>
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private String jdField_a_of_type_JavaLangString;
  private TextView b;
  
  public QCircleSpecialFollowUserItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560783;
  }
  
  protected String a()
  {
    return "QCircleSpecialFollowUse";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131373929));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373932));
    this.b = ((TextView)paramView.findViewById(2131373931));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131373933));
    this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundURL("https://sola.gtimg.cn/aoi/sola/20200619175130_E9peEWVngd.png");
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373930);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  protected void a(FeedCloudMeta.StRelationInfo paramStRelationInfo)
  {
    a(paramStRelationInfo, -1);
  }
  
  public void a(FeedCloudMeta.StRelationInfo paramStRelationInfo, int paramInt)
  {
    TextView localTextView = null;
    boolean bool2 = true;
    int i = 0;
    super.a(paramStRelationInfo, paramInt);
    this.jdField_a_of_type_JavaLangString = paramStRelationInfo.id.get();
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatar(uxx.a(getContext()), this.jdField_a_of_type_JavaLangString);
    Object localObject = localTextView;
    if (paramStRelationInfo.busiData.get() != null) {
      localObject = new QQCircleRelation.RelationBiz();
    }
    try
    {
      ((QQCircleRelation.RelationBiz)localObject).mergeFrom(paramStRelationInfo.busiData.get().toByteArray());
      if (localObject != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((QQCircleRelation.RelationBiz)localObject).nick.get());
        QLog.i("QCircleSpecialFollowUse", 4, "bindData: " + ((QQCircleRelation.RelationBiz)localObject).nick.get() + " " + ((QQCircleRelation.RelationBiz)localObject).qqRelation.get() + " " + ((QQCircleRelation.RelationBiz)localObject).sign.get() + " " + ((QQCircleRelation.RelationBiz)localObject).certification.get());
        localTextView = this.b;
        if (((QQCircleRelation.RelationBiz)localObject).sign.get() == null)
        {
          paramStRelationInfo = "";
          localTextView.setText(paramStRelationInfo);
          if (((QQCircleRelation.RelationBiz)localObject).qqRelation.get() != 1) {
            break label291;
          }
          bool1 = true;
          if (((QQCircleRelation.RelationBiz)localObject).certification.get() != 1) {
            break label297;
          }
          paramStRelationInfo = this.jdField_a_of_type_ComTencentImageURLImageView;
          if (!bool1) {
            break label342;
          }
          paramInt = i;
          paramStRelationInfo.setVisibility(paramInt);
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setIsAuth(bool2);
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramStRelationInfo)
    {
      for (;;)
      {
        QLog.w("QCircleSpecialFollowUse", 4, "bindData: merge data failed", paramStRelationInfo);
        localObject = localTextView;
        continue;
        paramStRelationInfo = ((QQCircleRelation.RelationBiz)localObject).sign.get();
        continue;
        label291:
        boolean bool1 = false;
        continue;
        label297:
        bool2 = false;
        continue;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
        this.b.setText("");
        bool1 = uxx.a(getContext(), this.jdField_a_of_type_JavaLangString);
        bool2 = false;
        continue;
        label342:
        paramInt = 8;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (aauy.a("QCircleSpecialFollowUse"))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      case 2131373931: 
      default: 
        break;
      case 2131373929: 
      case 2131373932: 
        Intent localIntent = new Intent();
        localIntent.putExtra("key_to_uin", this.jdField_a_of_type_JavaLangString);
        uxo.a(new uxk().a(this.jdField_a_of_type_JavaLangString).a(), localIntent);
        break;
      case 2131373930: 
        bglp.a(getContext(), 230, "提示", "取消后需要重新去他人的主页进行设置，确定取消吗？", "放弃", "确定", new vyp(this), new vyq(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleSpecialFollowUserItemView
 * JD-Core Version:    0.7.0.1
 */