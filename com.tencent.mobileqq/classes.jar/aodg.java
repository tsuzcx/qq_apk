import android.view.View;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import dov.com.tencent.biz.qqstory.takevideo.poilist.PoiListAdapter;
import dov.com.tencent.biz.qqstory.takevideo.poilist.SearchPoiListLayout;
import java.util.ArrayList;
import java.util.List;

public class aodg
  implements LbsManager.POIListRequestCallback
{
  public aodg(SearchPoiListLayout paramSearchPoiListLayout, String paramString) {}
  
  public void a(int paramInt, LbsManager.POIListRequestSession paramPOIListRequestSession, List paramList)
  {
    SearchPoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout, paramPOIListRequestSession);
    if (paramInt == 0) {
      if (paramPOIListRequestSession.a()) {
        break label201;
      }
    }
    label201:
    for (boolean bool = true;; bool = false)
    {
      SearchPoiListLayout.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout).setVisibility(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout.a(bool);
      if (SearchPoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout) == null) {
        SearchPoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout, new ArrayList());
      }
      if (SearchPoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout).b()) {
        SearchPoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout).clear();
      }
      SearchPoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout).addAll(paramList);
      if (SearchPoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout) != null)
      {
        SearchPoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout).a(SearchPoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout), null);
        SearchPoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout).notifyDataSetChanged();
        if (SearchPoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout).isEmpty())
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout.a(this.jdField_a_of_type_JavaLangString);
          SearchPoiListLayout.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout).setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      StoryReportor.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aodg
 * JD-Core Version:    0.7.0.1
 */