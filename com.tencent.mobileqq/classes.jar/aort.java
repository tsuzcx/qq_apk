import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.Key;
import java.security.interfaces.RSAKey;

class aort
{
  private String jdField_a_of_type_JavaLangString;
  private Key jdField_a_of_type_JavaSecurityKey;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public static aort a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("JsonWebSignature", 1, "token is null");
      return null;
    }
    String[] arrayOfString = paramString.split("\\.");
    if (arrayOfString.length != 3)
    {
      QLog.e("JsonWebSignature", 1, new Object[] { "jwt token illegal, length is ", Integer.valueOf(arrayOfString.length) });
      return null;
    }
    aort localaort = new aort();
    localaort.jdField_a_of_type_JavaLangString = paramString;
    localaort.b = arrayOfString[0];
    localaort.c = new String(Base64.decode(arrayOfString[0], 11));
    localaort.d = arrayOfString[1];
    localaort.e = new String(Base64.decode(arrayOfString[1], 11));
    localaort.f = arrayOfString[2];
    return localaort;
  }
  
  public static String a(String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramVarArgs.length)
    {
      if (paramVarArgs[i] == null) {}
      for (String str = "";; str = paramVarArgs[i])
      {
        localStringBuilder.append(str);
        if (i != paramVarArgs.length - 1) {
          localStringBuilder.append(".");
        }
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  private byte[] a()
  {
    Object localObject = a(new String[] { this.b, this.d });
    try
    {
      localObject = ((String)localObject).getBytes("US-ASCII");
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return null;
  }
  
  public String a()
  {
    return this.e;
  }
  
  public void a(Key paramKey)
  {
    this.jdField_a_of_type_JavaSecurityKey = paramKey;
  }
  
  public boolean a()
  {
    aorw localaorw = new aorw();
    if (((this.jdField_a_of_type_JavaSecurityKey instanceof RSAKey)) && (((RSAKey)this.jdField_a_of_type_JavaSecurityKey).getModulus().bitLength() < 2048)) {
      return false;
    }
    byte[] arrayOfByte1 = Base64.decode(this.f, 11);
    byte[] arrayOfByte2 = a();
    return localaorw.a(arrayOfByte1, this.jdField_a_of_type_JavaSecurityKey, arrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aort
 * JD-Core Version:    0.7.0.1
 */