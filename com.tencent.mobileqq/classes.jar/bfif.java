import android.util.Base64;
import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

final class bfif
  extends LruCache<String, bfjd>
{
  private static final byte[] jdField_a_of_type_ArrayOfByte = { 90, 39, 2, -61, -88, -75, -36, 105, -102, 55, 18, 69, -72, -11, -84, 50 };
  private static final byte[] jdField_b_of_type_ArrayOfByte = { -86, 39, 34, -61, -88, -75, -84, 105, 74, 39, 2, 35, -85, -74, -68, 105 };
  private File jdField_a_of_type_JavaIoFile;
  private List<Pair<String, bfjd>> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean = true;
  private File jdField_b_of_type_JavaIoFile;
  private boolean jdField_b_of_type_Boolean;
  
  public bfif(String paramString, int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_JavaIoFile = new File(paramString);
    this.jdField_b_of_type_JavaIoFile = new File(this.jdField_a_of_type_JavaIoFile.getPath() + ".bak");
    b();
  }
  
  private void a(bfik parambfik)
  {
    if (this.jdField_b_of_type_JavaIoFile.exists())
    {
      this.jdField_a_of_type_JavaIoFile.delete();
      this.jdField_b_of_type_JavaIoFile.renameTo(this.jdField_a_of_type_JavaIoFile);
    }
    if ((this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_JavaIoFile.isFile()))
    {
      int i = 0;
      if (this.jdField_a_of_type_JavaIoFile.length() > 10485760L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "Cache file too big: " + this.jdField_a_of_type_JavaIoFile.length());
        }
        i = 1;
      }
      new bfij(this.jdField_a_of_type_JavaIoFile, parambfik).a();
      if (i != 0)
      {
        bfhq.a(2, 2);
        this.jdField_a_of_type_JavaIoFile.delete();
      }
    }
  }
  
  private void a(String paramString, bfjd parambfjd, XmlSerializer paramXmlSerializer)
  {
    if (parambfjd.jdField_a_of_type_Long > new Date().getTime()) {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Write entry: " + parambfjd.toString());
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramXmlSerializer.startTag(null, "CacheEntry");
        paramXmlSerializer.attribute(null, "Key", paramString);
        paramXmlSerializer.attribute(null, "AttrType", Integer.toString(parambfjd.jdField_a_of_type_Int));
        paramXmlSerializer.attribute(null, "Category", Integer.toString(parambfjd.b));
        paramXmlSerializer.attribute(null, "SubCategory", Integer.toString(parambfjd.c));
        paramXmlSerializer.attribute(null, "Action", Integer.toString(parambfjd.d));
        paramXmlSerializer.attribute(null, "ExpireTime", Long.toString(parambfjd.jdField_a_of_type_Long));
        if (parambfjd.jdField_a_of_type_ArrayOfByte != null) {
          paramXmlSerializer.attribute(null, "ExtraInfo", Base64.encodeToString(parambfjd.jdField_a_of_type_ArrayOfByte, 0));
        }
        paramXmlSerializer.endTag(null, "CacheEntry");
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    QLog.d("QSec.AVEngine", 2, "Discard expired entry for write: " + parambfjd.toString());
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaIoFile.exists()) {
      if (!this.jdField_b_of_type_JavaIoFile.exists())
      {
        if (!this.jdField_a_of_type_JavaIoFile.renameTo(this.jdField_b_of_type_JavaIoFile)) {
          return false;
        }
      }
      else {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
    }
    new bfij(this.jdField_b_of_type_JavaIoFile, new bfii(this, this.jdField_a_of_type_JavaIoFile)).a();
    return true;
  }
  
  private bfjd b(String paramString)
  {
    paramString = new bfih(this, paramString);
    a(paramString);
    return paramString.a;
  }
  
  private void b()
  {
    a(new bfig(this));
  }
  
  public bfjd a(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    bfjd localbfjd;
    do
    {
      do
      {
        do
        {
          return localObject;
          localbfjd = (bfjd)super.get(paramString);
          if (localbfjd == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QSec.AVEngine", 2, "Hit memory cache for key: " + paramString);
          }
          localObject = localbfjd;
        } while (localbfjd.jdField_a_of_type_Long >= new Date().getTime());
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "Memory cache expired for key: " + paramString);
        }
        remove(paramString);
        return null;
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        localObject = localbfjd;
      } while (this.jdField_b_of_type_Boolean != true);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Look from cache file for key: " + paramString);
      }
      localbfjd = b(paramString);
      localObject = localbfjd;
    } while (localbfjd == null);
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "Hit file cache for key: " + paramString);
    }
    if (localbfjd.jdField_a_of_type_Long < new Date().getTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "File cache expired for key: " + paramString);
      }
      return null;
    }
    put(paramString, localbfjd);
    return localbfjd;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      a();
    }
  }
  
  public void a(String paramString, bfjd parambfjd)
  {
    if ((paramString != null) && (parambfjd != null))
    {
      if (put(paramString, parambfjd) == null) {
        this.jdField_a_of_type_JavaUtilList.add(new Pair(paramString, parambfjd));
      }
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Put to cache, key: %s, result: %s ", new Object[] { paramString, parambfjd.toString() }));
      }
      if (this.jdField_a_of_type_JavaUtilList.size() >= 5)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "Trigger rebuild cache file");
        }
        a();
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, bfjd parambfjd1, bfjd parambfjd2)
  {
    super.entryRemoved(paramBoolean, paramString, parambfjd1, parambfjd2);
    if (!paramBoolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "Memory cache overflow.");
    }
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfif
 * JD-Core Version:    0.7.0.1
 */