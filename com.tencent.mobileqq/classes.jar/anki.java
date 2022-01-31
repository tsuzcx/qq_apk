import android.view.ViewGroup;
import android.widget.ListView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter;

class anki
  implements Runnable
{
  anki(ankh paramankh) {}
  
  public void run()
  {
    FaceListPage.a(this.a.a.a).setVisibility(4);
    FaceListPage.b(this.a.a.a).setVisibility(4);
    FaceListPage.a(this.a.a.a).setVisibility(0);
    FaceListPage.a(this.a.a.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anki
 * JD-Core Version:    0.7.0.1
 */