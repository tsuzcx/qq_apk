import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class apqe
  implements apqb
{
  apqe(apqd paramapqd, apqg paramapqg, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Apqg != null) {
      this.jdField_a_of_type_Apqg.a(apqd.a(this.jdField_a_of_type_Apqd, paramLong1, 0));
    }
  }
  
  public void a(boolean paramBoolean, apqc paramapqc)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "onARResourceDownloadComplete result" + paramBoolean);
    if (this.jdField_a_of_type_Apqg != null) {
      this.jdField_a_of_type_Apqg.a(paramapqc.jdField_a_of_type_Int, paramBoolean);
    }
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localapqc = (apqc)localIterator.next();
          if (!localapqc.jdField_a_of_type_JavaLangString.equals(paramapqc.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          if (paramapqc.jdField_a_of_type_Boolean) {}
          try
          {
            System.currentTimeMillis();
            if (paramapqc.jdField_a_of_type_Int == 6)
            {
              new File(paramapqc.c);
              apqh.a(paramapqc.c, appx.b());
            }
            for (;;)
            {
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  ");
              this.b.remove(localapqc);
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  remove " + localapqc.jdField_a_of_type_JavaLangString);
              break;
              if (paramapqc.jdField_a_of_type_Int != 7) {
                break label268;
              }
              apqh.a(paramapqc.c, appx.a(paramapqc.b));
            }
            return;
          }
          catch (Exception localException)
          {
            new File(paramapqc.c).delete();
            QLog.i("AREngine_ARResourceManagerTools", 1, "Download end. uncompressZip error. url = ");
            if (this.jdField_a_of_type_Apqg != null) {
              this.jdField_a_of_type_Apqg.a(false);
            }
            this.jdField_a_of_type_Apqd.a();
            QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerAllDownloadComplete  ");
          }
        }
      }
      label268:
      while (this.b.size() != 0) {
        for (;;)
        {
          apqc localapqc;
          File localFile = new File(paramapqc.c);
          apqh.a(paramapqc.c, localFile.getParentFile().getAbsolutePath() + File.separator + paramapqc.b + File.separator);
        }
      }
      if (this.jdField_a_of_type_Apqg != null) {
        this.jdField_a_of_type_Apqg.a(true);
      }
      this.jdField_a_of_type_Apqd.a();
      return;
    }
    if (this.jdField_a_of_type_Apqg != null) {
      this.jdField_a_of_type_Apqg.a(false);
    }
    this.jdField_a_of_type_Apqd.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqe
 * JD-Core Version:    0.7.0.1
 */