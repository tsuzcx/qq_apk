import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;

public class anor
{
  public static void a(Intent paramIntent, auod paramauod)
  {
    paramauod.j = paramIntent.getStringExtra("doutuBigMd5");
    paramauod.d = paramIntent.getLongExtra("doutuBigFileSize", 0L);
    paramauod.k = paramIntent.getStringExtra("doutuThumbMD5");
    paramauod.l = paramIntent.getStringExtra("doutuSupplierName");
  }
  
  public static void a(aywc paramaywc, ayyy paramayyy)
  {
    if (paramaywc.p)
    {
      paramayyy.jdField_a_of_type_Long = paramaywc.f;
      if (paramaywc.n != null) {
        paramayyy.jdField_a_of_type_ArrayOfByte = bbea.a(paramaywc.n);
      }
      paramayyy.e = 2;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, auod paramauod)
  {
    paramMessageRecord.saveExtInfoToExtStr("doutu_big_md5", paramauod.j);
    paramMessageRecord.saveExtInfoToExtStr("doutu_big_file_size", String.valueOf(paramauod.d));
    paramMessageRecord.saveExtInfoToExtStr("doutu_thumb_md5", String.valueOf(paramauod.k));
    paramMessageRecord.saveExtInfoToExtStr("doutu_supplier_name", paramauod.l);
  }
  
  public static void a(MessageRecord paramMessageRecord, aywc paramaywc, int paramInt)
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
        paramaywc.p = true;
        paramaywc.f = l;
        paramaywc.n = paramMessageRecord;
      }
      if (localPicMessageExtraData.imageBizType != 4) {
        break label180;
      }
      paramMessageRecord = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramMessageRecord instanceof AppInterface))
      {
        paramMessageRecord = aezl.a((AppInterface)paramMessageRecord).b();
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
 * Qualified Name:     anor
 * JD-Core Version:    0.7.0.1
 */