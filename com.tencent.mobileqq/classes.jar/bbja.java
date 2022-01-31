import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.14;
import com.tencent.qphone.base.util.QLog;

public class bbja
  implements upk
{
  public bbja(TroopBarPublishActivity.14 param14) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("tribe_publish_TroopBarPublishActivity", 2, "compositeVideo: errorCode = " + paramInt);
      }
      this.a.this$0.a(null, this.a.a);
      return;
    }
    this.a.this$0.jdField_a_of_type_Bbct.b = this.a.this$0.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
    this.a.this$0.jdField_a_of_type_Bbct.c = this.a.this$0.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight;
    this.a.this$0.jdField_a_of_type_Bbct.a = ((int)this.a.this$0.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDuration);
    this.a.this$0.a(paramString2, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbja
 * JD-Core Version:    0.7.0.1
 */