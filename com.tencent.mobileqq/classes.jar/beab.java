import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.xmlpull.v1.XmlSerializer;

final class beab
  extends bead
{
  File jdField_a_of_type_JavaIoFile;
  private OutputStream jdField_a_of_type_JavaIoOutputStream;
  private XmlSerializer jdField_a_of_type_OrgXmlpullV1XmlSerializer;
  
  public beab(bdzy parambdzy, File paramFile)
  {
    super(null);
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public void a()
  {
    try
    {
      Object localObject1;
      Object localObject2;
      if (this.jdField_a_of_type_OrgXmlpullV1XmlSerializer == null)
      {
        localObject1 = new IvParameterSpec(bdzy.a());
        localObject2 = new SecretKeySpec(bdzy.b(), "AES");
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        localCipher.init(1, (Key)localObject2, (AlgorithmParameterSpec)localObject1);
        this.jdField_a_of_type_JavaIoOutputStream = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(this.jdField_a_of_type_JavaIoFile)), localCipher);
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer = Xml.newSerializer();
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.setOutput(this.jdField_a_of_type_JavaIoOutputStream, "UTF-8");
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.startTag(null, "AVCloudCache");
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.attribute(null, "Ver", Integer.toString(1));
      }
      if (bdzy.a(this.jdField_a_of_type_Bdzy).size() > 0)
      {
        localObject1 = bdzy.a(this.jdField_a_of_type_Bdzy).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Pair)((Iterator)localObject1).next();
          if (QLog.isColorLevel()) {
            QLog.d("QSec.AVEngine", 2, "Add new cache entry: " + ((beaw)((Pair)localObject2).second).toString());
          }
          bdzy.a(this.jdField_a_of_type_Bdzy, (String)((Pair)localObject2).first, (beaw)((Pair)localObject2).second, this.jdField_a_of_type_OrgXmlpullV1XmlSerializer);
        }
      }
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      for (;;)
      {
        if (this.jdField_a_of_type_JavaIoOutputStream != null) {}
        try
        {
          this.jdField_a_of_type_JavaIoOutputStream.close();
          return;
        }
        catch (Exception localException2) {}
        bdzy.a(this.jdField_a_of_type_Bdzy).clear();
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.endTag(null, "AVCloudCache");
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.endDocument();
        bdzy.a(this.jdField_a_of_type_Bdzy).delete();
      }
    }
  }
  
  public boolean a(String paramString, beaw parambeaw)
  {
    try
    {
      if (this.jdField_a_of_type_OrgXmlpullV1XmlSerializer == null)
      {
        IvParameterSpec localIvParameterSpec = new IvParameterSpec(bdzy.a());
        SecretKeySpec localSecretKeySpec = new SecretKeySpec(bdzy.b(), "AES");
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        localCipher.init(1, localSecretKeySpec, localIvParameterSpec);
        this.jdField_a_of_type_JavaIoOutputStream = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(this.jdField_a_of_type_JavaIoFile)), localCipher);
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer = Xml.newSerializer();
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.setOutput(this.jdField_a_of_type_JavaIoOutputStream, "UTF-8");
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.startTag(null, "AVCloudCache");
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.attribute(null, "Ver", Integer.toString(1));
      }
      bdzy.a(this.jdField_a_of_type_Bdzy, paramString, parambeaw, this.jdField_a_of_type_OrgXmlpullV1XmlSerializer);
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.jdField_a_of_type_OrgXmlpullV1XmlSerializer = null;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beab
 * JD-Core Version:    0.7.0.1
 */