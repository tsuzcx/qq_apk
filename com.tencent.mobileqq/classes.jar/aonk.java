import com.tencent.qphone.base.util.QLog;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class aonk
{
  private Signature a()
  {
    try
    {
      Signature localSignature = Signature.getInstance("SHA256withRSA");
      return localSignature;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      QLog.e("RsaUsingShaAlgorithm", 1, new Object[] { "getSignature error : ", localNoSuchAlgorithmException.getMessage() });
    }
    return null;
  }
  
  private boolean a(Signature paramSignature, Key paramKey)
  {
    try
    {
      paramSignature.initVerify((PublicKey)paramKey);
      return true;
    }
    catch (InvalidKeyException paramSignature)
    {
      QLog.e("RsaUsingShaAlgorithm", 1, new Object[] { "initForVerify error : ", paramSignature.getMessage() });
    }
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte1, Key paramKey, byte[] paramArrayOfByte2)
  {
    Signature localSignature = a();
    if (localSignature == null)
    {
      QLog.e("RsaUsingShaAlgorithm", 1, "verifySignature fail");
      return false;
    }
    if (!a(localSignature, paramKey))
    {
      QLog.e("RsaUsingShaAlgorithm", 1, "initForVerify fail");
      return false;
    }
    try
    {
      localSignature.update(paramArrayOfByte2);
      boolean bool = localSignature.verify(paramArrayOfByte1);
      return bool;
    }
    catch (SignatureException paramArrayOfByte1) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aonk
 * JD-Core Version:    0.7.0.1
 */