import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;

class boca
  implements bnyw
{
  boca(bobx parambobx, bocb parambocb, String paramString1, AEEditorDownloadResBean paramAEEditorDownloadResBean, String paramString2, String paramString3) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bocb.a(paramInt);
  }
  
  public void a(bdwt parambdwt)
  {
    boolean bool3 = false;
    if (parambdwt == null)
    {
      if (this.jdField_a_of_type_Bocb != null) {
        this.jdField_a_of_type_Bocb.a(false);
      }
      this.jdField_a_of_type_Bobx.a(this.jdField_a_of_type_JavaLangString, false);
      return;
    }
    boolean bool1;
    boolean bool2;
    if (parambdwt.a == 0)
    {
      bool1 = true;
      bnzb.b(this.jdField_a_of_type_Bobx.c, "downLoadOneResInternal-onDownloadFinish---isSuccess=" + bool1 + ", id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
      bool2 = bool3;
      if (bool1)
      {
        String str = bgmg.c(this.b);
        if ((str == null) || (!str.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {
          break label321;
        }
      }
    }
    for (;;)
    {
      try
      {
        bool2 = this.jdField_a_of_type_Bobx.a(this.b, this.c, this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId(), this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bobx.a(bool1, parambdwt.b, parambdwt.g, this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
        if (!bool2) {
          bgmg.a(this.c);
        }
        bgmg.d(this.b);
        bnzb.b(this.jdField_a_of_type_Bobx.c, "downLoadOneResInternal-onDownloadFinish---REAL result=" + bool2 + ", id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
        if (this.jdField_a_of_type_Bocb != null) {
          this.jdField_a_of_type_Bocb.a(bool2);
        }
        this.jdField_a_of_type_Bobx.a(this.jdField_a_of_type_JavaLangString, bool2);
        return;
        bool1 = false;
      }
      catch (Exception localException)
      {
        bnzb.a(this.jdField_a_of_type_Bobx.c, "downLoadOneResInternal-onDownloadFinish---unZipFile failed, id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId(), localException);
        localException.printStackTrace();
        bool2 = bool3;
        continue;
      }
      label321:
      bnzb.d(this.jdField_a_of_type_Bobx.c, "downLoadOneResInternal-onDownloadFinish---MD5 check failed, id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
      bool2 = bool3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boca
 * JD-Core Version:    0.7.0.1
 */