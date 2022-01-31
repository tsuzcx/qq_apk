import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;

public class amye
{
  public static void a(Intent paramIntent, atqd paramatqd)
  {
    paramatqd.j = paramIntent.getStringExtra("doutuBigMd5");
    paramatqd.d = paramIntent.getLongExtra("doutuBigFileSize", 0L);
    paramatqd.k = paramIntent.getStringExtra("doutuThumbMD5");
    paramatqd.l = paramIntent.getStringExtra("doutuSupplierName");
  }
  
  public static void a(axvt paramaxvt, axyp paramaxyp)
  {
    if (paramaxvt.p)
    {
      paramaxyp.jdField_a_of_type_Long = paramaxvt.f;
      if (paramaxvt.n != null) {
        paramaxyp.jdField_a_of_type_ArrayOfByte = bach.a(paramaxvt.n);
      }
      paramaxyp.e = 2;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, atqd paramatqd)
  {
    paramMessageRecord.saveExtInfoToExtStr("doutu_big_md5", paramatqd.j);
    paramMessageRecord.saveExtInfoToExtStr("doutu_big_file_size", String.valueOf(paramatqd.d));
    paramMessageRecord.saveExtInfoToExtStr("doutu_thumb_md5", String.valueOf(paramatqd.k));
    paramMessageRecord.saveExtInfoToExtStr("doutu_supplier_name", paramatqd.l);
  }
  
  public static void a(MessageRecord paramMessageRecord, axvt paramaxvt, int paramInt)
  {
    PicMessageExtraData localPicMessageExtraData = new PicMessageExtraData();
    if (paramInt == 1044) {}
    for (paramInt = 3;; paramInt = 4)
    {
      localPicMessageExtraData.imageBizType = paramInt;
      localPicMessageExtraData.doutuSupplier = paramMessageRecord.getExtInfoFromExtStr("doutu_supplier_name");
      if ((paramMessageRecord instanceof MessageForPic)) {
        ((MessageForPic)paramMessageRecord).picExtraData = localPicMessageExtraData;
      }
      long l = Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("doutu_big_file_size")).longValue();
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("doutu_big_md5");
      if ((l > 0L) && (paramMessageRecord != null) && (paramMessageRecord.length() > 0))
      {
        paramaxvt.p = true;
        paramaxvt.f = l;
        paramaxvt.n = paramMessageRecord;
      }
      if (localPicMessageExtraData.imageBizType != 4) {
        break label180;
      }
      paramMessageRecord = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramMessageRecord instanceof AppInterface))
      {
        paramMessageRecord = aeor.a((AppInterface)paramMessageRecord).b();
        if (!TextUtils.isEmpty(paramMessageRecord)) {
          break;
        }
      }
      return;
    }
    localPicMessageExtraData.textSummary = ("[" + paramMessageRecord + "]");
    return;
    label180:
    localPicMessageExtraData.textSummary = BaseApplicationImpl.getApplication().getString(2131625713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amye
 * JD-Core Version:    0.7.0.1
 */