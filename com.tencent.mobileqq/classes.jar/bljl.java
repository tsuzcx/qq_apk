import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;

class bljl
  implements blfc
{
  bljl(bljh parambljh, bljm parambljm, String paramString1, AEEditorDownloadResBean paramAEEditorDownloadResBean, String paramString2, String paramString3) {}
  
  public void a(int paramInt) {}
  
  public void a(baqw parambaqw)
  {
    boolean bool3 = false;
    if (parambaqw == null)
    {
      if (this.jdField_a_of_type_Bljm != null) {
        this.jdField_a_of_type_Bljm.a(false);
      }
      bljh.a(this.jdField_a_of_type_Bljh, this.jdField_a_of_type_JavaLangString, false);
      return;
    }
    boolean bool1;
    boolean bool2;
    if (parambaqw.a == 0)
    {
      bool1 = true;
      blfg.b("AEEditorFiltersManager", "downLoadOneResInternal-onDownloadFinish---isSuccess=" + bool1 + ", id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
      bool2 = bool3;
      if (bool1)
      {
        String str = bdcs.c(this.b);
        if ((str == null) || (!str.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {
          break label309;
        }
      }
    }
    for (;;)
    {
      try
      {
        bool2 = bljh.a(this.jdField_a_of_type_Bljh, this.b, this.c, this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId(), this.jdField_a_of_type_JavaLangString);
        blen.a().a(bool1, 3, "AEEditorFilter", this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId(), parambaqw.b, parambaqw.h);
        if (!bool2) {
          bdcs.a(this.c);
        }
        bdcs.d(this.b);
        blfg.b("AEEditorFiltersManager", "downLoadOneResInternal-onDownloadFinish---REAL result=" + bool2 + ", id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
        if (this.jdField_a_of_type_Bljm != null) {
          this.jdField_a_of_type_Bljm.a(bool2);
        }
        bljh.a(this.jdField_a_of_type_Bljh, this.jdField_a_of_type_JavaLangString, bool2);
        return;
        bool1 = false;
      }
      catch (Exception localException)
      {
        blfg.a("AEEditorFiltersManager", "downLoadOneResInternal-onDownloadFinish---unZipFile failed, id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId(), localException);
        localException.printStackTrace();
        bool2 = bool3;
        continue;
      }
      label309:
      blfg.d("AEEditorFiltersManager", "downLoadOneResInternal-onDownloadFinish---MD5 check failed, id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
      bool2 = bool3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljl
 * JD-Core Version:    0.7.0.1
 */