import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;

class blnx
  implements bljj
{
  blnx(blnt paramblnt, blny paramblny, String paramString1, AEEditorDownloadResBean paramAEEditorDownloadResBean, String paramString2, String paramString3) {}
  
  public void a(int paramInt) {}
  
  public void a(bavf parambavf)
  {
    boolean bool3 = false;
    if (parambavf == null)
    {
      if (this.jdField_a_of_type_Blny != null) {
        this.jdField_a_of_type_Blny.a(false);
      }
      blnt.a(this.jdField_a_of_type_Blnt, this.jdField_a_of_type_JavaLangString, false);
      return;
    }
    boolean bool1;
    boolean bool2;
    if (parambavf.a == 0)
    {
      bool1 = true;
      bljn.b("AEEditorFiltersManager", "downLoadOneResInternal-onDownloadFinish---isSuccess=" + bool1 + ", id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
      bool2 = bool3;
      if (bool1)
      {
        String str = bdhb.c(this.b);
        if ((str == null) || (!str.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {
          break label309;
        }
      }
    }
    for (;;)
    {
      try
      {
        bool2 = blnt.a(this.jdField_a_of_type_Blnt, this.b, this.c, this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId(), this.jdField_a_of_type_JavaLangString);
        bliu.a().a(bool1, 3, "AEEditorFilter", this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId(), parambavf.b, parambavf.h);
        if (!bool2) {
          bdhb.a(this.c);
        }
        bdhb.d(this.b);
        bljn.b("AEEditorFiltersManager", "downLoadOneResInternal-onDownloadFinish---REAL result=" + bool2 + ", id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
        if (this.jdField_a_of_type_Blny != null) {
          this.jdField_a_of_type_Blny.a(bool2);
        }
        blnt.a(this.jdField_a_of_type_Blnt, this.jdField_a_of_type_JavaLangString, bool2);
        return;
        bool1 = false;
      }
      catch (Exception localException)
      {
        bljn.a("AEEditorFiltersManager", "downLoadOneResInternal-onDownloadFinish---unZipFile failed, id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId(), localException);
        localException.printStackTrace();
        bool2 = bool3;
        continue;
      }
      label309:
      bljn.d("AEEditorFiltersManager", "downLoadOneResInternal-onDownloadFinish---MD5 check failed, id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
      bool2 = bool3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blnx
 * JD-Core Version:    0.7.0.1
 */