import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.utils.VipUtils;

class amsh
  implements amlp
{
  amsh(amsg paramamsg) {}
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    amsg localamsg = this.a;
    if (amsg.a(this.a).jdField_b_of_type_Boolean)
    {
      paramStartCheckParam = amsg.a(this.a).e;
      amsg.a(localamsg, paramStartCheckParam);
      if (!"message".equals(amsg.a(this.a).f)) {
        break label101;
      }
    }
    label101:
    for (int i = 1;; i = 0)
    {
      VipUtils.a(null, "cmshow", "Apollo", "download_confirm", i, 3, new String[] { String.valueOf(amsg.a(this.a).jdField_b_of_type_Int) });
      return;
      paramStartCheckParam = amsg.a(this.a).d;
      break;
    }
  }
  
  public void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (amsg.a(this.a) != null) {
      amsg.a(this.a).c(-10001, amsg.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsh
 * JD-Core Version:    0.7.0.1
 */