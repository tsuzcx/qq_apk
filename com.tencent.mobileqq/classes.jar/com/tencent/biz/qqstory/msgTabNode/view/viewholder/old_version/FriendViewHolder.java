package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class FriendViewHolder
  extends BaseViewHolder
{
  private FaceDrawable g;
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.itemView.setTag(paramMsgTabNodeInfo.d);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      Object localObject2 = (QQAppInterface)localObject1;
      String str = String.valueOf(paramMsgTabNodeInfo.c);
      this.g = FaceDrawable.getFaceDrawable((AppInterface)localObject2, 1, str);
      this.b.setImageDrawable(this.g);
      localObject1 = ContactUtils.g((AppInterface)localObject2, str);
      this.d.setText((CharSequence)localObject1);
      ThreadManager.post(new FriendViewHolder.1(this, (QQAppInterface)localObject2, str), 8, null, true);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("FriendViewHolder userItem = ");
        ((StringBuilder)localObject2).append(paramMsgTabNodeInfo.c);
        ((StringBuilder)localObject2).append(", name = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", faceDrawable = ");
        ((StringBuilder)localObject2).append(this.g);
        QLog.e("zivonchen", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.FriendViewHolder
 * JD-Core Version:    0.7.0.1
 */