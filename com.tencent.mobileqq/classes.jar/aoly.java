import com.tencent.widget.XListView;
import dov.com.tencent.biz.qqstory.takevideo.poilist.PoiListLayout;

public class aoly
  implements Runnable
{
  public aoly(PoiListLayout paramPoiListLayout) {}
  
  public void run()
  {
    PoiListLayout.a(this.a).springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoly
 * JD-Core Version:    0.7.0.1
 */