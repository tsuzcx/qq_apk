import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class apco
  implements apcl
{
  apco(apcn paramapcn, apcq paramapcq, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Apcq != null) {
      this.jdField_a_of_type_Apcq.a(apcn.a(this.jdField_a_of_type_Apcn, paramLong1, 0));
    }
  }
  
  public void a(boolean paramBoolean, apcm paramapcm)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "onARResourceDownloadComplete result" + paramBoolean);
    if (this.jdField_a_of_type_Apcq != null) {
      this.jdField_a_of_type_Apcq.a(paramapcm.jdField_a_of_type_Int, paramBoolean);
    }
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localapcm = (apcm)localIterator.next();
          if (!localapcm.jdField_a_of_type_JavaLangString.equals(paramapcm.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          if (paramapcm.jdField_a_of_type_Boolean) {}
          try
          {
            System.currentTimeMillis();
            if (paramapcm.jdField_a_of_type_Int == 6)
            {
              new File(paramapcm.c);
              apcr.a(paramapcm.c, apch.b());
            }
            for (;;)
            {
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  ");
              this.b.remove(localapcm);
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  remove " + localapcm.jdField_a_of_type_JavaLangString);
              break;
              if (paramapcm.jdField_a_of_type_Int != 7) {
                break label268;
              }
              apcr.a(paramapcm.c, apch.a(paramapcm.b));
            }
            return;
          }
          catch (Exception localException)
          {
            new File(paramapcm.c).delete();
            QLog.i("AREngine_ARResourceManagerTools", 1, "Download end. uncompressZip error. url = ");
            if (this.jdField_a_of_type_Apcq != null) {
              this.jdField_a_of_type_Apcq.a(false);
            }
            this.jdField_a_of_type_Apcn.a();
            QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerAllDownloadComplete  ");
          }
        }
      }
      label268:
      while (this.b.size() != 0) {
        for (;;)
        {
          apcm localapcm;
          File localFile = new File(paramapcm.c);
          apcr.a(paramapcm.c, localFile.getParentFile().getAbsolutePath() + File.separator + paramapcm.b + File.separator);
        }
      }
      if (this.jdField_a_of_type_Apcq != null) {
        this.jdField_a_of_type_Apcq.a(true);
      }
      this.jdField_a_of_type_Apcn.a();
      return;
    }
    if (this.jdField_a_of_type_Apcq != null) {
      this.jdField_a_of_type_Apcq.a(false);
    }
    this.jdField_a_of_type_Apcn.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apco
 * JD-Core Version:    0.7.0.1
 */