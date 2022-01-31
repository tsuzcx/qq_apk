import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;

public class apfy
{
  public static void a(Intent paramIntent, awfl paramawfl)
  {
    paramawfl.j = paramIntent.getStringExtra("doutuBigMd5");
    paramawfl.d = paramIntent.getLongExtra("doutuBigFileSize", 0L);
    paramawfl.k = paramIntent.getStringExtra("doutuThumbMD5");
    paramawfl.l = paramIntent.getStringExtra("doutuSupplierName");
  }
  
  public static void a(baub parambaub, bawx parambawx)
  {
    if (parambaub.p)
    {
      parambawx.jdField_a_of_type_Long = parambaub.f;
      if (parambaub.n != null) {
        parambawx.jdField_a_of_type_ArrayOfByte = bdcv.a(parambaub.n);
      }
      parambawx.e = 2;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, awfl paramawfl)
  {
    paramMessageRecord.saveExtInfoToExtStr("doutu_big_md5", paramawfl.j);
    paramMessageRecord.saveExtInfoToExtStr("doutu_big_file_size", String.valueOf(paramawfl.d));
    paramMessageRecord.saveExtInfoToExtStr("doutu_thumb_md5", String.valueOf(paramawfl.k));
    paramMessageRecord.saveExtInfoToExtStr("doutu_supplier_name", paramawfl.l);
  }
  
  public static void a(MessageRecord paramMessageRecord, baub parambaub, int paramInt)
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
        parambaub.p = true;
        parambaub.f = l;
        parambaub.n = paramMessageRecord;
      }
      if (localPicMessageExtraData.imageBizType != 4) {
        break label180;
      }
      paramMessageRecord = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramMessageRecord instanceof AppInterface))
      {
        paramMessageRecord = agwq.a((AppInterface)paramMessageRecord).b();
        if (!TextUtils.isEmpty(paramMessageRecord)) {
          break;
        }
      }
      return;
    }
    localPicMessageExtraData.textSummary = ("[" + paramMessageRecord + "]");
    return;
    label180:
    localPicMessageExtraData.textSummary = BaseApplicationImpl.getApplication().getString(2131691342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfy
 * JD-Core Version:    0.7.0.1
 */