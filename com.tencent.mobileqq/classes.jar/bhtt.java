import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout;

public class bhtt
  extends GridLayoutManager.SpanSizeLookup
{
  public bhtt(ShopLayout paramShopLayout) {}
  
  public int getSpanSize(int paramInt)
  {
    if (ShopLayout.a(this.a).getItemViewType(paramInt) == 0) {
      return 1;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhtt
 * JD-Core Version:    0.7.0.1
 */