import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

class awha
  extends AsyncTask<Void, Void, Integer>
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private awgz jdField_a_of_type_Awgz;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "";
  private String d = "";
  private String e = "SendAfterCombinePicAndDataTask";
  
  public awha(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, awgz paramawgz)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awgz = paramawgz;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  int a()
  {
    String str1 = awgy.a() + "temp/" + System.currentTimeMillis();
    String str2 = awgy.a() + "temp/" + System.currentTimeMillis() + "_data";
    boolean bool = false;
    if (this.jdField_a_of_type_Awgz != null) {
      bool = this.jdField_a_of_type_Awgz.a(str2);
    }
    if (!bool) {
      return awgy.g;
    }
    if (!apvd.a(str2)) {
      return awgy.h;
    }
    Object localObject = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_c_of_type_Int = localObject.length;
    if (!awhh.a((byte[])localObject, str2, str1)) {
      return awgy.e;
    }
    localObject = awhh.a(str1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return awgy.f;
    }
    this.jdField_b_of_type_JavaLangString = ((String)localObject);
    this.jdField_c_of_type_JavaLangString = awgy.a(this.jdField_b_of_type_JavaLangString);
    this.d = awgy.b(this.jdField_b_of_type_JavaLangString);
    if (!awhh.a(str1, this.jdField_c_of_type_JavaLangString).booleanValue()) {
      return awgy.e;
    }
    if (!awhh.a(str2, this.d).booleanValue()) {
      return awgy.e;
    }
    apvd.c(str1);
    apvd.c(str2);
    return awgy.d;
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a());
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    QLog.i(this.e, 2, "doBeforeSendScribble result = " + paramInteger);
    if (paramInteger.intValue() == awgy.d)
    {
      awgu localawgu = new awgu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      MessageForScribble localMessageForScribble = localawgu.a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      localMessageForScribble.mExistInfo.mCombineFileExist = true;
      localMessageForScribble.mExistInfo.mDataFileExist = true;
      localMessageForScribble.mExistInfo.mLocalPathExist = true;
      localMessageForScribble.mExistInfo.mInit = true;
      localawgu.a(localMessageForScribble);
    }
    if (this.jdField_a_of_type_Awgz != null) {
      this.jdField_a_of_type_Awgz.a(paramInteger.intValue());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awha
 * JD-Core Version:    0.7.0.1
 */