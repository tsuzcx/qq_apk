import android.util.Base64;
import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

final class bhiz
  extends LruCache<String, bhjx>
{
  private static final byte[] jdField_a_of_type_ArrayOfByte = { 90, 39, 2, -61, -88, -75, -36, 105, -102, 55, 18, 69, -72, -11, -84, 50 };
  private static final byte[] jdField_b_of_type_ArrayOfByte = { -86, 39, 34, -61, -88, -75, -84, 105, 74, 39, 2, 35, -85, -74, -68, 105 };
  private File jdField_a_of_type_JavaIoFile;
  private List<Pair<String, bhjx>> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean = true;
  private File jdField_b_of_type_JavaIoFile;
  private boolean jdField_b_of_type_Boolean;
  
  public bhiz(String paramString, int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_JavaIoFile = new File(paramString);
    this.jdField_b_of_type_JavaIoFile = new File(this.jdField_a_of_type_JavaIoFile.getPath() + ".bak");
    b();
  }
  
  private void a(bhje parambhje)
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
      new bhjd(this.jdField_a_of_type_JavaIoFile, parambhje).a();
      if (i != 0)
      {
        bhik.a(2, 2);
        this.jdField_a_of_type_JavaIoFile.delete();
      }
    }
  }
  
  private void a(String paramString, bhjx parambhjx, XmlSerializer paramXmlSerializer)
  {
    if (parambhjx.jdField_a_of_type_Long > new Date().getTime()) {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Write entry: " + parambhjx.toString());
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramXmlSerializer.startTag(null, "CacheEntry");
        paramXmlSerializer.attribute(null, "Key", paramString);
        paramXmlSerializer.attribute(null, "AttrType", Integer.toString(parambhjx.jdField_a_of_type_Int));
        paramXmlSerializer.attribute(null, "Category", Integer.toString(parambhjx.b));
        paramXmlSerializer.attribute(null, "SubCategory", Integer.toString(parambhjx.c));
        paramXmlSerializer.attribute(null, "Action", Integer.toString(parambhjx.d));
        paramXmlSerializer.attribute(null, "ExpireTime", Long.toString(parambhjx.jdField_a_of_type_Long));
        if (parambhjx.jdField_a_of_type_ArrayOfByte != null) {
          paramXmlSerializer.attribute(null, "ExtraInfo", Base64.encodeToString(parambhjx.jdField_a_of_type_ArrayOfByte, 0));
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
    QLog.d("QSec.AVEngine", 2, "Discard expired entry for write: " + parambhjx.toString());
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
    new bhjd(this.jdField_b_of_type_JavaIoFile, new bhjc(this, this.jdField_a_of_type_JavaIoFile)).a();
    return true;
  }
  
  private bhjx b(String paramString)
  {
    paramString = new bhjb(this, paramString);
    a(paramString);
    return paramString.a;
  }
  
  private void b()
  {
    a(new bhja(this));
  }
  
  public bhjx a(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    bhjx localbhjx;
    do
    {
      do
      {
        do
        {
          return localObject;
          localbhjx = (bhjx)super.get(paramString);
          if (localbhjx == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QSec.AVEngine", 2, "Hit memory cache for key: " + paramString);
          }
          localObject = localbhjx;
        } while (localbhjx.jdField_a_of_type_Long >= new Date().getTime());
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "Memory cache expired for key: " + paramString);
        }
        remove(paramString);
        return null;
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        localObject = localbhjx;
      } while (this.jdField_b_of_type_Boolean != true);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Look from cache file for key: " + paramString);
      }
      localbhjx = b(paramString);
      localObject = localbhjx;
    } while (localbhjx == null);
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "Hit file cache for key: " + paramString);
    }
    if (localbhjx.jdField_a_of_type_Long < new Date().getTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "File cache expired for key: " + paramString);
      }
      return null;
    }
    put(paramString, localbhjx);
    return localbhjx;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      a();
    }
  }
  
  public void a(String paramString, bhjx parambhjx)
  {
    if ((paramString != null) && (parambhjx != null))
    {
      if (put(paramString, parambhjx) == null) {
        this.jdField_a_of_type_JavaUtilList.add(new Pair(paramString, parambhjx));
      }
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Put to cache, key: %s, result: %s ", new Object[] { paramString, parambhjx.toString() }));
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
  
  protected void a(boolean paramBoolean, String paramString, bhjx parambhjx1, bhjx parambhjx2)
  {
    super.entryRemoved(paramBoolean, paramString, parambhjx1, parambhjx2);
    if (!paramBoolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "Memory cache overflow.");
    }
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhiz
 * JD-Core Version:    0.7.0.1
 */