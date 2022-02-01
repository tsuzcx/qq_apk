package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.widget.RotateCircleImageView;
import com.tencent.biz.qqstory.widget.RotateCircleImageView.BorderStyle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class SelfViewHolder
  extends BaseViewHolder
{
  protected static String g;
  protected static int i = 0;
  protected static int j = 1;
  protected static int k = 2;
  protected boolean h;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.qqstory.msgTab.");
    localStringBuilder.append(SelfViewHolder.class.getSimpleName());
    g = localStringBuilder.toString();
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.itemView.setTag(paramMsgTabNodeInfo.d);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
      Object localObject2 = String.valueOf(paramMsgTabNodeInfo.c);
      localObject1 = localObject2;
      if ("0".equals(localObject2)) {
        localObject1 = localQQAppInterface.getCurrentAccountUin();
      }
      Object localObject3 = (UserManager)SuperManager.a(2);
      localObject2 = QQStoryContext.a().i();
      localObject3 = ((UserManager)localObject3).b((String)localObject2);
      if (localObject3 == null) {
        if ("0_1000".equals(localObject2))
        {
          localObject2 = new QQUserUIItem.UserID(String.valueOf(localObject1), "");
          new GetUserInfoHandler().a(0, (QQUserUIItem.UserID)localObject2, String.valueOf(localObject1));
        }
        else
        {
          QQUserUIItem.UserID localUserID = new QQUserUIItem.UserID("", (String)localObject2);
          new GetUserInfoHandler().a(1, localUserID, (String)localObject2);
        }
      }
      boolean bool;
      if ((localObject3 != null) && (((QQUserUIItem)localObject3).isVip())) {
        bool = true;
      } else {
        bool = false;
      }
      this.h = bool;
      if (this.h)
      {
        PlayModeUtils.b(this.b, ((QQUserUIItem)localObject3).headUrl, true, (int)DisplayUtils.a(this.d.getContext(), 50.0F));
      }
      else
      {
        localObject1 = FaceDrawable.getFaceDrawable(localQQAppInterface, 1, (String)localObject1);
        this.b.setImageDrawable((Drawable)localObject1);
      }
      this.d.setText(HardCodeUtil.a(2131911233));
      if (QLog.isDevelopLevel()) {
        QLog.d(g, 2, new Object[] { "update self view, isUploading:", Boolean.valueOf(paramMsgTabNodeInfo.s), ", unUploadVideoCount: ", Integer.valueOf(paramMsgTabNodeInfo.r) });
      }
      if (paramMsgTabNodeInfo.s)
      {
        a(paramMsgTabNodeInfo, j);
        return;
      }
      if (paramMsgTabNodeInfo.r > 0)
      {
        a(paramMsgTabNodeInfo, k);
        return;
      }
      a(paramMsgTabNodeInfo, i);
    }
  }
  
  protected void a(MsgTabNodeInfo paramMsgTabNodeInfo, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(g, 2, new Object[] { "setViewStatus: status=", Integer.valueOf(paramInt) });
    }
    if (paramInt == i)
    {
      a(paramMsgTabNodeInfo.e.size(), paramMsgTabNodeInfo.i);
      if (this.h)
      {
        this.c.setImageResource(2130848417);
        this.c.setVisibility(0);
        return;
      }
      this.c.setVisibility(8);
      return;
    }
    if (paramInt == j)
    {
      this.a.setBorderStyle(RotateCircleImageView.BorderStyle.ROTATE);
      this.c.setVisibility(8);
      return;
    }
    if (paramInt == k)
    {
      this.a.setBorderStyle(RotateCircleImageView.BorderStyle.STILL);
      this.a.setBorderColors(new int[] { -65536 });
      this.c.setImageResource(2130848423);
      this.c.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.SelfViewHolder
 * JD-Core Version:    0.7.0.1
 */