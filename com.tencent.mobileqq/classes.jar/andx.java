import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class andx
  implements andu
{
  andx(andw paramandw, andz paramandz, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Andz != null) {
      this.jdField_a_of_type_Andz.a(andw.a(this.jdField_a_of_type_Andw, paramLong1, 0));
    }
  }
  
  public void a(boolean paramBoolean, andv paramandv)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "onARResourceDownloadComplete result" + paramBoolean);
    if (this.jdField_a_of_type_Andz != null) {
      this.jdField_a_of_type_Andz.a(paramandv.jdField_a_of_type_Int, paramBoolean);
    }
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localandv = (andv)localIterator.next();
          if (!localandv.jdField_a_of_type_JavaLangString.equals(paramandv.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          if (paramandv.jdField_a_of_type_Boolean) {}
          try
          {
            System.currentTimeMillis();
            if (paramandv.jdField_a_of_type_Int == 6)
            {
              new File(paramandv.c);
              anea.a(paramandv.c, andq.b());
            }
            for (;;)
            {
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  ");
              this.b.remove(localandv);
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  remove " + localandv.jdField_a_of_type_JavaLangString);
              break;
              if (paramandv.jdField_a_of_type_Int != 7) {
                break label268;
              }
              anea.a(paramandv.c, andq.a(paramandv.b));
            }
            return;
          }
          catch (Exception localException)
          {
            new File(paramandv.c).delete();
            QLog.i("AREngine_ARResourceManagerTools", 1, "Download end. uncompressZip error. url = ");
            if (this.jdField_a_of_type_Andz != null) {
              this.jdField_a_of_type_Andz.a(false);
            }
            this.jdField_a_of_type_Andw.a();
            QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerAllDownloadComplete  ");
          }
        }
      }
      label268:
      while (this.b.size() != 0) {
        for (;;)
        {
          andv localandv;
          File localFile = new File(paramandv.c);
          anea.a(paramandv.c, localFile.getParentFile().getAbsolutePath() + File.separator + paramandv.b + File.separator);
        }
      }
      if (this.jdField_a_of_type_Andz != null) {
        this.jdField_a_of_type_Andz.a(true);
      }
      this.jdField_a_of_type_Andw.a();
      return;
    }
    if (this.jdField_a_of_type_Andz != null) {
      this.jdField_a_of_type_Andz.a(false);
    }
    this.jdField_a_of_type_Andw.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andx
 * JD-Core Version:    0.7.0.1
 */