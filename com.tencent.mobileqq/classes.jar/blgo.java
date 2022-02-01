import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

class blgo
  implements blgf
{
  blgo(blgn paramblgn, String paramString, long paramLong, blfr paramblfr, int paramInt) {}
  
  public void a(blfn paramblfn, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramblfn == null) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramblfn.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean)
    {
      if (paramblfn.jdField_a_of_type_Blfp == null)
      {
        blgn.a(this.jdField_a_of_type_Blgn).a(this.jdField_a_of_type_Long, 1810024, "");
        return;
      }
      blgn.a(this.jdField_a_of_type_Blgn).a(this.jdField_a_of_type_Long, paramblfn.jdField_a_of_type_Blfp);
      return;
    }
    if ((paramInt == 1002) && (!this.jdField_a_of_type_Blfr.a()))
    {
      this.jdField_a_of_type_Blfr.d(true);
      paramblfn = Message.obtain();
      paramblfn.what = 21;
      paramblfn.obj = this.jdField_a_of_type_Blfr;
      paramblfn.arg1 = this.jdField_a_of_type_Int;
      blgn.a(this.jdField_a_of_type_Blgn).sendMessageDelayed(paramblfn, 1000L);
      return;
    }
    blgn.a(this.jdField_a_of_type_Blgn).a(this.jdField_a_of_type_Long, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgo
 * JD-Core Version:    0.7.0.1
 */