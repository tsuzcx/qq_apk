import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

class ayce
  extends AsyncTask<Void, Void, Integer>
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private aycd jdField_a_of_type_Aycd;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "";
  private String d = "";
  private String e = "SendAfterCombinePicAndDataTask";
  
  public ayce(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, aycd paramaycd)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aycd = paramaycd;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  int a()
  {
    String str1 = aycc.a() + "temp/" + System.currentTimeMillis();
    String str2 = aycc.a() + "temp/" + System.currentTimeMillis() + "_data";
    boolean bool = false;
    if (this.jdField_a_of_type_Aycd != null) {
      bool = this.jdField_a_of_type_Aycd.a(str2);
    }
    if (!bool) {
      return aycc.g;
    }
    if (!arof.a(str2)) {
      return aycc.h;
    }
    Object localObject = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_c_of_type_Int = localObject.length;
    if (!aycl.a((byte[])localObject, str2, str1)) {
      return aycc.e;
    }
    localObject = aycl.a(str1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return aycc.f;
    }
    this.jdField_b_of_type_JavaLangString = ((String)localObject);
    this.jdField_c_of_type_JavaLangString = aycc.a(this.jdField_b_of_type_JavaLangString);
    this.d = aycc.b(this.jdField_b_of_type_JavaLangString);
    if (!aycl.a(str1, this.jdField_c_of_type_JavaLangString).booleanValue()) {
      return aycc.e;
    }
    if (!aycl.a(str2, this.d).booleanValue()) {
      return aycc.e;
    }
    arof.c(str1);
    arof.c(str2);
    return aycc.d;
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a());
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    QLog.i(this.e, 2, "doBeforeSendScribble result = " + paramInteger);
    if (paramInteger.intValue() == aycc.d)
    {
      ayby localayby = new ayby(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      MessageForScribble localMessageForScribble = localayby.a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      localMessageForScribble.mExistInfo.mCombineFileExist = true;
      localMessageForScribble.mExistInfo.mDataFileExist = true;
      localMessageForScribble.mExistInfo.mLocalPathExist = true;
      localMessageForScribble.mExistInfo.mInit = true;
      localayby.a(localMessageForScribble);
    }
    if (this.jdField_a_of_type_Aycd != null) {
      this.jdField_a_of_type_Aycd.a(paramInteger.intValue());
    }
  }
  
  public byte[] a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayce
 * JD-Core Version:    0.7.0.1
 */