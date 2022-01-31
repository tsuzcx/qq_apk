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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import ofm;
import ofo;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class MessageNotifySegment
  extends SegmentView
  implements View.OnClickListener
{
  public static final String KEY = "MessageNotifySegment";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Integer jdField_a_of_type_JavaLangInteger;
  private String jdField_a_of_type_JavaLangString;
  
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
    if (this.jdField_a_of_type_Int == 0)
    {
      paramBaseViewHolder.a(2131362733).setVisibility(8);
      paramBaseViewHolder.a().setLayoutParams(new AbsListView.LayoutParams(-1, 0));
      return paramBaseViewHolder.a();
    }
    paramInt = UIUtils.a(paramBaseViewHolder.a().getContext(), 52.0F);
    paramBaseViewHolder.a(2131362733).setVisibility(0);
    paramBaseViewHolder.a().setLayoutParams(new AbsListView.LayoutParams(-1, paramInt));
    paramBaseViewHolder.a().setVisibility(0);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131362724);
    Drawable localDrawable = ImageUtil.b();
    QQStoryContext.a();
    if (QQStoryContext.a() == null) {
      localImageView.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      return paramBaseViewHolder.a();
      if ((localImageView.getTag() != null) && ((this.jdField_a_of_type_JavaLangInteger == null) || (this.jdField_a_of_type_JavaLangInteger.equals(localImageView.getTag())))) {
        return paramBaseViewHolder.a();
      }
      localImageView.setTag(this.jdField_a_of_type_JavaLangInteger);
      localImageView.setImageDrawable(localDrawable);
      TextView localTextView = (TextView)paramBaseViewHolder.a(2131363062);
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.jdField_a_of_type_Int > 99) {}
      for (paramViewGroup = "99+";; paramViewGroup = Integer.valueOf(this.jdField_a_of_type_Int))
      {
        localTextView.setText(paramViewGroup + "条新消息");
        if (this.jdField_a_of_type_Long > 0L) {
          break label269;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "uin <=0. fetch first message.");
        }
        a(localImageView);
        break;
      }
      label269:
      ThreadManager.post(new ofm(this, localImageView, localDrawable), 8, null, true);
    }
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970796, paramViewGroup, false);
    paramViewGroup.findViewById(2131362733).setOnClickListener(this);
    return new BaseViewHolder(paramViewGroup);
  }
  
  public String a()
  {
    return "MessageNotifySegment";
  }
  
  public void a(ImageView paramImageView)
  {
    qqstory_710_message.ReqStoryMessageList localReqStoryMessageList = new qqstory_710_message.ReqStoryMessageList();
    localReqStoryMessageList.num.set(1);
    localReqStoryMessageList.start_time.set(0);
    localReqStoryMessageList.source.set(0);
    localReqStoryMessageList.version_ctrl.set(760);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "fetch first message from gray, start=0");
    }
    QQStoryContext.a();
    ProtoUtils.a(QQStoryContext.a(), new ofo(this, paramImageView), localReqStoryMessageList.toByteArray(), StoryApi.a("StorySvc.get_710_message_list"));
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if ((paramRedDotInfo != null) && (paramRedDotInfo.uint32_appid.get() == 49) && (paramRedDotInfo.bool_display_reddot.get()) && (paramRedDotInfo.uint32_number.get() > 0))
    {
      this.jdField_a_of_type_Int = paramRedDotInfo.uint32_number.get();
      this.jdField_a_of_type_Long = paramRedDotInfo.uint64_cmd_uin.get();
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramRedDotInfo.uint32_last_time.get());
      this.jdField_a_of_type_JavaLangString = paramRedDotInfo.str_face_url.get().toStringUtf8();
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  protected void c()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    if (localQQAppInterface != null)
    {
      a(((TroopRedTouchManager)localQQAppInterface.getManager(69)).a(49));
      return;
    }
    SLog.e("Q.qqstory.home.MessageNotifySegment", "Get the QQAppInterface is null,we dont know the red point state");
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, StoryMessageListActivity.class);
    paramView.putExtra("qqstory_message_list_source", 0);
    paramView.putExtra("qqstory_jump_source", "2");
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    paramView = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().b());
    if ((paramView != null) && (paramView.isVip))
    {
      i = 1;
      if (i == 0) {
        break label124;
      }
    }
    label124:
    for (int i = 1;; i = 2)
    {
      StoryReportor.a("play_video", "clk_grey", i, 0, new String[] { "", "", "", "" });
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment
 * JD-Core Version:    0.7.0.1
 */