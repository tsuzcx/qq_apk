import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.utils.VipUtils;

class aneb
  implements amxj
{
  aneb(anea paramanea) {}
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    anea localanea = this.a;
    if (anea.a(this.a).jdField_b_of_type_Boolean)
    {
      paramStartCheckParam = anea.a(this.a).e;
      anea.a(localanea, paramStartCheckParam);
      if (!"message".equals(anea.a(this.a).f)) {
        break label101;
      }
    }
    label101:
    for (int i = 1;; i = 0)
    {
      VipUtils.a(null, "cmshow", "Apollo", "download_confirm", i, 3, new String[] { String.valueOf(anea.a(this.a).jdField_b_of_type_Int) });
      return;
      paramStartCheckParam = anea.a(this.a).d;
      break;
    }
  }
  
  public void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (anea.a(this.a) != null) {
      anea.a(this.a).c(-10001, anea.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aneb
 * JD-Core Version:    0.7.0.1
 */