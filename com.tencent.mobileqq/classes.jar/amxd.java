import java.io.File;
import java.util.zip.ZipEntry;

class amxd
  implements nml
{
  amxd(amxc paramamxc, StringBuilder paramStringBuilder, String paramString) {}
  
  public boolean a(ZipEntry paramZipEntry)
  {
    if (paramZipEntry.isDirectory())
    {
      if ((this.jdField_a_of_type_Amxc.a != null) && (this.jdField_a_of_type_Amxc.a.length > 0))
      {
        localObject = this.jdField_a_of_type_Amxc.a;
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          int k = localObject[i];
          if (paramZipEntry.getName().equals(Integer.valueOf(k + File.separatorChar)))
          {
            this.jdField_a_of_type_JavaLangStringBuilder.append(paramZipEntry.getName()).append(" download, ");
            return false;
          }
          i += 1;
        }
      }
      Object localObject = new File(this.jdField_a_of_type_JavaLangString + paramZipEntry.getName());
      if ((localObject != null) && (((File)localObject).isDirectory()) && (((File)localObject).list().length >= 3))
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append(paramZipEntry.getName()).append(" exist, ");
        return false;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramZipEntry.getName()).append(" copy, ");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxd
 * JD-Core Version:    0.7.0.1
 */