import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.gamecenter.protocol.GetArkTailRsp;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;

final class atyy
  implements BusinessObserver
{
  atyy(WeakReference paramWeakReference1, WeakReference paramWeakReference2, WeakReference paramWeakReference3, long paramLong1, long paramLong2, AIOImageData paramAIOImageData) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (GetArkTailRsp)paramBundle.getSerializable("rsp");
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.Util", 2, "GetArkTailRspFromGallery:" + paramBoolean + "|" + paramBundle);
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      Object localObject = (Context)this.jdField_a_of_type_MqqUtilWeakReference.get();
      TextView localTextView = (TextView)this.jdField_b_of_type_MqqUtilWeakReference.get();
      agzi localagzi = (agzi)this.c.get();
      if (((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing()) && (localTextView != null) && (localagzi != null) && (localagzi.a() != null) && (localagzi.a().a != null) && (localagzi.a().a.jdField_f_of_type_Long == this.jdField_a_of_type_Long) && (localagzi.a().a.jdField_f_of_type_Int == this.jdField_b_of_type_Long))
      {
        localTextView.setText(paramBundle.desc);
        localTextView.setTag(-1, paramBundle.jump_url);
        localTextView.setTag(-2, Integer.valueOf(paramBundle.type));
        localTextView.setTag(-3, Integer.valueOf(paramBundle.sub_type));
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("game_source_pic_txt", paramBundle.desc);
      ((Bundle)localObject).putString("game_source_pic_url", paramBundle.jump_url);
      ((Bundle)localObject).putInt("game_source_type_pic", paramBundle.type);
      ((Bundle)localObject).putInt("game_source_subtype_pic", paramBundle.sub_type);
      ((Bundle)localObject).putLong("uniseq", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_Long);
      ((Bundle)localObject).putInt("is_troop", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.g);
      ((Bundle)localObject).putString("friend_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.l);
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "saveGalleryDataToMsg", (Bundle)localObject, null);
      localObject = (StructMsgForImageShare)bchh.a((byte[])this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a);
      atyv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData, (StructMsgForImageShare)localObject, paramBundle.desc, paramBundle.jump_url, paramBundle.type, paramBundle.sub_type, true);
      atyv.a(((StructMsgForImageShare)localObject).mSourceAppid + "", paramBundle.sub_type, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyy
 * JD-Core Version:    0.7.0.1
 */