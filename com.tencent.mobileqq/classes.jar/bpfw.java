import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig.ConfigData;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class bpfw
  extends bpen
  implements bpbt, IEventReceiver
{
  private int jdField_a_of_type_Int = 0;
  private TransferData jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData = new TransferData();
  private int b;
  
  public bpfw(@NonNull bpep parambpep)
  {
    super(parambpep);
  }
  
  public static int a(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      i = 0;
    }
    while (paramInt == 2) {
      return i;
    }
    return -1;
  }
  
  public static long a()
  {
    return -200L;
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.getPositions();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      this.jdField_a_of_type_Int = 1;
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    Long localLong;
    for (long l = 0L; ((Iterator)localObject).hasNext(); l = localLong.longValue())
    {
      localLong = (Long)((Iterator)localObject).next();
      if (localLong.longValue() - l < 2000L)
      {
        this.jdField_a_of_type_Int = 2;
        return;
      }
    }
    if (paramLong - l < 2000L)
    {
      this.jdField_a_of_type_Int = 2;
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.mConfigData.mID != -1) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.getPositions().size() > 0);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    a(bpbt.class, this);
    if ((this.jdField_a_of_type_Bpep.a.a instanceof EditLocalPhotoSource)) {
      this.jdField_a_of_type_Int = 3;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 0)
      {
        localObject = ((bolb)bojv.a(5)).a;
        if (localObject != null)
        {
          localObject = ((bpyf)localObject).a();
          a(Integer.parseInt(((TransitionCategoryItem)localObject).a));
          bpye.a().a((TransitionCategoryItem)localObject);
          localObject = (bpay)a(bpay.class);
          if ((localObject != null) && (!(this.jdField_a_of_type_Bpep instanceof bpwv))) {
            ((bpay)localObject).b();
          }
        }
        if (AudioHelper.g()) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.setReverseShift(a());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoTransfer", 2, "onCreate, state:" + this.jdField_a_of_type_Int);
      }
      Object localObject = (bozu)a(bozu.class);
      if (this.jdField_a_of_type_Int != 0) {
        ((bozu)localObject).b();
      }
      yqu.a("video_edit_transition", "exp_transition", a(this.jdField_a_of_type_Bpep.a.a("extra_transiton_src_from", -1)), 0, new String[0]);
      return;
      if ((this.jdField_a_of_type_Bpep.a.a instanceof EditLocalVideoSource))
      {
        this.jdField_a_of_type_Int = 3;
      }
      else if ((this.jdField_a_of_type_Bpep.a.a instanceof EditTakeVideoSource))
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.setPositions(((EditTakeVideoSource)this.jdField_a_of_type_Bpep.a.a).a.mTransferPosList);
        if (this.jdField_a_of_type_Bpep.a.a("extra_transiton_src_from", -1) == 1) {
          this.jdField_a_of_type_Int = 0;
        } else {
          a(((EditTakeVideoSource)this.jdField_a_of_type_Bpep.a.a).a.mDuration);
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = TransferConfig.getConfigData(paramInt);
    if (paramInt == 1)
    {
      ((TransferConfig.ConfigData)localObject).mCommonFloat1 = null;
      ((TransferConfig.ConfigData)localObject).mCommonFloat2 = null;
      ((TransferConfig.ConfigData)localObject).mCommonFloat3 = null;
      ((TransferConfig.ConfigData)localObject).mCommonFloat4 = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.setConfigData((TransferConfig.ConfigData)localObject);
    if (c())
    {
      localObject = (bpez)a(bpez.class);
      if (localObject != null) {
        ((bpez)localObject).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_Int != 0) {}
    do
    {
      return;
      if (paramInt2 == 42)
      {
        this.b = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.mConfigData.mID;
        a(-1);
        return;
      }
    } while (paramInt1 != 42);
    a(this.b);
  }
  
  public void a(int paramInt, @NonNull bpsf parambpsf)
  {
    super.a(paramInt, parambpsf);
    if (!b()) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.toJSONObject();
    } while (TextUtils.isEmpty(str));
    parambpsf.a.putExtra("transfer_effect_data", str);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      if (b()) {
        paramJSONObject.put("EditVideoTransfer", this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.toJSONObject());
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 1) {
      QQToast.a(a(), 2131718663, 0).a();
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    QQToast.a(a(), 2131718662, 0).a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoTransfer", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpfw
 * JD-Core Version:    0.7.0.1
 */