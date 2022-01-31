import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.font.FontInterface.FontResult;
import cooperation.qzone.font.FontManager;
import java.io.File;

public class amud
  implements Runnable
{
  public amud(FontManager paramFontManager, int paramInt1, int paramInt2, FontInterface.FontResult paramFontResult, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = FontManager.a(this.jdField_a_of_type_CooperationQzoneFontFontManager);
    Object localObject2 = new File((String)localObject1, FontManager.a(this.jdField_a_of_type_CooperationQzoneFontFontManager, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
    if (((File)localObject2).exists())
    {
      if (this.jdField_a_of_type_CooperationQzoneFontFontInterface$FontResult == null) {
        break label162;
      }
      FontManager.a().a(((File)localObject2).getAbsolutePath(), true);
      this.jdField_a_of_type_CooperationQzoneFontFontInterface$FontResult.a(this.jdField_a_of_type_Int, ((File)localObject2).getAbsolutePath(), this.jdField_a_of_type_JavaLangString);
    }
    label162:
    while ((FontManager.a(this.jdField_a_of_type_CooperationQzoneFontFontManager, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_CooperationQzoneFontFontInterface$FontResult)) || (this.jdField_a_of_type_CooperationQzoneFontFontInterface$FontResult == null))
    {
      return;
      if (this.jdField_b_of_type_Int == 1)
      {
        localObject1 = new File((String)localObject1, FontManager.a(this.jdField_a_of_type_CooperationQzoneFontFontManager, this.jdField_a_of_type_Int, 0));
        if (((File)localObject1).exists())
        {
          localObject2 = FontManager.b(this.jdField_a_of_type_CooperationQzoneFontFontManager, this.jdField_a_of_type_Int, 1);
          if (FontManager.a(this.jdField_a_of_type_CooperationQzoneFontFontManager, ((File)localObject1).getAbsolutePath(), (String)localObject2))
          {
            this.jdField_a_of_type_CooperationQzoneFontFontInterface$FontResult.a(this.jdField_a_of_type_Int, (String)localObject2, this.jdField_a_of_type_JavaLangString);
            return;
          }
        }
      }
    }
    this.jdField_a_of_type_CooperationQzoneFontFontInterface$FontResult.a(this.jdField_a_of_type_Int, null, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amud
 * JD-Core Version:    0.7.0.1
 */