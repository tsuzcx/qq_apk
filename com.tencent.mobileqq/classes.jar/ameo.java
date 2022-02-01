import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ameo
  implements View.OnClickListener
{
  ameo(amen paramamen) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof ameu)))
    {
      localObject = (ameu)localObject;
      bfpx.a(amen.a(this.a), amen.a(this.a), ((ameu)localObject).a);
      bftx localbftx = (bftx)amen.a(this.a).getManager(203);
      if ((localbftx != null) && (localbftx.a(amen.a(this.a), ((ameu)localObject).a, amen.a(this.a)))) {
        localbftx.a(amen.a(this.a), ((ameu)localObject).a);
      }
      if (amen.a(this.a) != null) {
        break label121;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label121:
      bcst.b(amen.a(this.a).app, "dc00898", "", "", "", "0X8009F9F", 0, 0, ((ameu)localObject).a, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ameo
 * JD-Core Version:    0.7.0.1
 */