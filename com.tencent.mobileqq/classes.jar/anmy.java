import com.tencent.widget.XListView;
import dov.com.tencent.biz.qqstory.takevideo.poilist.PoiListLayout;

public class anmy
  implements Runnable
{
  public anmy(PoiListLayout paramPoiListLayout) {}
  
  public void run()
  {
    PoiListLayout.a(this.a).springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anmy
 * JD-Core Version:    0.7.0.1
 */