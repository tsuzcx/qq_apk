import android.animation.TypeEvaluator;

class bagi
  implements TypeEvaluator
{
  bagi(bagf parambagf) {}
  
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    paramFloat = 3.0F * paramFloat;
    if (paramFloat <= 0.45F) {
      return Float.valueOf(1.0F - paramFloat / 0.45F * 0.6F);
    }
    if (paramFloat <= 1.3F) {
      return Double.valueOf((paramFloat - 0.45F) / 0.85F * 0.6F + 0.4D);
    }
    if (paramFloat <= 2.45F) {
      return Float.valueOf(1.0F - (paramFloat - 1.3F) / 1.15F * 0.6F);
    }
    return Double.valueOf((paramFloat - 2.45F) / 0.55F * 0.6F + 0.4D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagi
 * JD-Core Version:    0.7.0.1
 */