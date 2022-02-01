import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;

class bpdv
  implements bpah
{
  bpdv(bpds parambpds, bpdw parambpdw, String paramString1, AEEditorDownloadResBean paramAEEditorDownloadResBean, String paramString2, String paramString3) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bpdw != null) {
      this.jdField_a_of_type_Bpdw.a(paramInt);
    }
  }
  
  public void a(bevm parambevm)
  {
    boolean bool3 = false;
    if (parambevm == null)
    {
      if (this.jdField_a_of_type_Bpdw != null) {
        this.jdField_a_of_type_Bpdw.a(false);
      }
      this.jdField_a_of_type_Bpds.a(this.jdField_a_of_type_JavaLangString, false);
      return;
    }
    boolean bool1;
    boolean bool2;
    if (parambevm.a == 0)
    {
      bool1 = true;
      bpam.b(this.jdField_a_of_type_Bpds.c, "downLoadOneResInternal-onDownloadFinish---isSuccess=" + bool1 + ", id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
      bool2 = bool3;
      if (bool1)
      {
        String str = bhmi.c(this.b);
        if ((str == null) || (!str.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {
          break label321;
        }
      }
    }
    for (;;)
    {
      try
      {
        bool2 = this.jdField_a_of_type_Bpds.a(this.b, this.c, this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId(), this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bpds.a(bool1, parambevm.b, parambevm.g, this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
        if (!bool2) {
          bhmi.a(this.c);
        }
        bhmi.d(this.b);
        bpam.b(this.jdField_a_of_type_Bpds.c, "downLoadOneResInternal-onDownloadFinish---REAL result=" + bool2 + ", id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
        if (this.jdField_a_of_type_Bpdw != null) {
          this.jdField_a_of_type_Bpdw.a(bool2);
        }
        this.jdField_a_of_type_Bpds.a(this.jdField_a_of_type_JavaLangString, bool2);
        return;
        bool1 = false;
      }
      catch (Exception localException)
      {
        bpam.a(this.jdField_a_of_type_Bpds.c, "downLoadOneResInternal-onDownloadFinish---unZipFile failed, id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId(), localException);
        localException.printStackTrace();
        bool2 = bool3;
        continue;
      }
      label321:
      bpam.d(this.jdField_a_of_type_Bpds.c, "downLoadOneResInternal-onDownloadFinish---MD5 check failed, id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
      bool2 = bool3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdv
 * JD-Core Version:    0.7.0.1
 */