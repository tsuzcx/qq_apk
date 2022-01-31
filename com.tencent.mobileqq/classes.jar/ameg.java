import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.ICloudAVEngine.ResultBundle;
import com.tencent.util.Pair;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.Key;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import org.xmlpull.v1.XmlSerializer;

final class ameg
  extends amei
{
  File jdField_a_of_type_JavaIoFile;
  private OutputStream jdField_a_of_type_JavaIoOutputStream;
  private XmlSerializer jdField_a_of_type_OrgXmlpullV1XmlSerializer;
  
  public ameg(amed paramamed, File paramFile)
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
        localObject1 = new SecretKeySpec(".#s?*%2 ".getBytes(), "DES");
        localObject2 = Cipher.getInstance("DES");
        ((Cipher)localObject2).init(1, (Key)localObject1);
        this.jdField_a_of_type_JavaIoOutputStream = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(this.jdField_a_of_type_JavaIoFile)), (Cipher)localObject2);
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer = Xml.newSerializer();
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.setOutput(this.jdField_a_of_type_JavaIoOutputStream, "UTF-8");
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.startTag(null, "AVCloudCache");
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.attribute(null, "Ver", Integer.toString(1));
      }
      if (amed.a(this.jdField_a_of_type_Amed).size() > 0)
      {
        localObject1 = amed.a(this.jdField_a_of_type_Amed).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Pair)((Iterator)localObject1).next();
          if (QLog.isColorLevel()) {
            QLog.d("QSec.AVEngine", 2, "Add new cache entry: " + ((ICloudAVEngine.ResultBundle)((Pair)localObject2).second).toString());
          }
          amed.a(this.jdField_a_of_type_Amed, (String)((Pair)localObject2).first, (ICloudAVEngine.ResultBundle)((Pair)localObject2).second, this.jdField_a_of_type_OrgXmlpullV1XmlSerializer);
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
        amed.a(this.jdField_a_of_type_Amed).clear();
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.endTag(null, "AVCloudCache");
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.endDocument();
        amed.a(this.jdField_a_of_type_Amed).delete();
      }
    }
  }
  
  public boolean a(String paramString, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    try
    {
      if (this.jdField_a_of_type_OrgXmlpullV1XmlSerializer == null)
      {
        SecretKeySpec localSecretKeySpec = new SecretKeySpec(".#s?*%2 ".getBytes(), "DES");
        Cipher localCipher = Cipher.getInstance("DES");
        localCipher.init(1, localSecretKeySpec);
        this.jdField_a_of_type_JavaIoOutputStream = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(this.jdField_a_of_type_JavaIoFile)), localCipher);
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer = Xml.newSerializer();
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.setOutput(this.jdField_a_of_type_JavaIoOutputStream, "UTF-8");
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.startTag(null, "AVCloudCache");
        this.jdField_a_of_type_OrgXmlpullV1XmlSerializer.attribute(null, "Ver", Integer.toString(1));
      }
      amed.a(this.jdField_a_of_type_Amed, paramString, paramResultBundle, this.jdField_a_of_type_OrgXmlpullV1XmlSerializer);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ameg
 * JD-Core Version:    0.7.0.1
 */