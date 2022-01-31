import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;

public class anom
{
  public static void a(Intent paramIntent, auob paramauob)
  {
    paramauob.j = paramIntent.getStringExtra("doutuBigMd5");
    paramauob.d = paramIntent.getLongExtra("doutuBigFileSize", 0L);
    paramauob.k = paramIntent.getStringExtra("doutuThumbMD5");
    paramauob.l = paramIntent.getStringExtra("doutuSupplierName");
  }
  
  public static void a(aywa paramaywa, ayyw paramayyw)
  {
    if (paramaywa.p)
    {
      paramayyw.jdField_a_of_type_Long = paramaywa.f;
      if (paramaywa.n != null) {
        paramayyw.jdField_a_of_type_ArrayOfByte = bbdm.a(paramaywa.n);
      }
      paramayyw.e = 2;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, auob paramauob)
  {
    paramMessageRecord.saveExtInfoToExtStr("doutu_big_md5", paramauob.j);
    paramMessageRecord.saveExtInfoToExtStr("doutu_big_file_size", String.valueOf(paramauob.d));
    paramMessageRecord.saveExtInfoToExtStr("doutu_thumb_md5", String.valueOf(paramauob.k));
    paramMessageRecord.saveExtInfoToExtStr("doutu_supplier_name", paramauob.l);
  }
  
  public static void a(MessageRecord paramMessageRecord, aywa paramaywa, int paramInt)
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
        paramaywa.p = true;
        paramaywa.f = l;
        paramaywa.n = paramMessageRecord;
      }
      if (localPicMessageExtraData.imageBizType != 4) {
        break label180;
      }
      paramMessageRecord = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramMessageRecord instanceof AppInterface))
      {
        paramMessageRecord = aezn.a((AppInterface)paramMessageRecord).b();
        if (!TextUtils.isEmpty(paramMessageRecord)) {
          break;
        }
      }
      return;
    }
    localPicMessageExtraData.textSummary = ("[" + paramMessageRecord + "]");
    return;
    label180:
    localPicMessageExtraData.textSummary = BaseApplicationImpl.getApplication().getString(2131691289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anom
 * JD-Core Version:    0.7.0.1
 */