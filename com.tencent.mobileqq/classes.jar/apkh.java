import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;

public class apkh
{
  public static void a(Intent paramIntent, awju paramawju)
  {
    paramawju.j = paramIntent.getStringExtra("doutuBigMd5");
    paramawju.d = paramIntent.getLongExtra("doutuBigFileSize", 0L);
    paramawju.k = paramIntent.getStringExtra("doutuThumbMD5");
    paramawju.l = paramIntent.getStringExtra("doutuSupplierName");
  }
  
  public static void a(bayk parambayk, bbbg parambbbg)
  {
    if (parambayk.p)
    {
      parambbbg.jdField_a_of_type_Long = parambayk.f;
      if (parambayk.n != null) {
        parambbbg.jdField_a_of_type_ArrayOfByte = bdhe.a(parambayk.n);
      }
      parambbbg.e = 2;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, awju paramawju)
  {
    paramMessageRecord.saveExtInfoToExtStr("doutu_big_md5", paramawju.j);
    paramMessageRecord.saveExtInfoToExtStr("doutu_big_file_size", String.valueOf(paramawju.d));
    paramMessageRecord.saveExtInfoToExtStr("doutu_thumb_md5", String.valueOf(paramawju.k));
    paramMessageRecord.saveExtInfoToExtStr("doutu_supplier_name", paramawju.l);
  }
  
  public static void a(MessageRecord paramMessageRecord, bayk parambayk, int paramInt)
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
        parambayk.p = true;
        parambayk.f = l;
        parambayk.n = paramMessageRecord;
      }
      if (localPicMessageExtraData.imageBizType != 4) {
        break label180;
      }
      paramMessageRecord = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramMessageRecord instanceof AppInterface))
      {
        paramMessageRecord = ahbf.a((AppInterface)paramMessageRecord).b();
        if (!TextUtils.isEmpty(paramMessageRecord)) {
          break;
        }
      }
      return;
    }
    localPicMessageExtraData.textSummary = ("[" + paramMessageRecord + "]");
    return;
    label180:
    localPicMessageExtraData.textSummary = BaseApplicationImpl.getApplication().getString(2131691343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apkh
 * JD-Core Version:    0.7.0.1
 */