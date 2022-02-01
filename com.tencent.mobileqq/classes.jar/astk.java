import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmotionPanel;
import com.tencent.qphone.base.util.QLog;

public class astk
  implements asta
{
  public astk(RelatedEmotionPanel paramRelatedEmotionPanel) {}
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    if (RelatedEmotionPanel.a(this.a) != null) {
      RelatedEmotionPanel.a(this.a).a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RelatedEmotionPanel", 4, "dismiss type: " + paramInt);
    }
    if (paramInt > -1) {
      bdll.b(RelatedEmotionPanel.a(this.a), "dc00898", "", this.a.a, "0X800B11A", "0X800B11A", paramInt, 0, "", "", "", "");
    }
    this.a.a();
    if (paramInt == 2) {
      AbstractGifImage.resumeAll();
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astk
 * JD-Core Version:    0.7.0.1
 */