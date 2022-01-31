import android.view.View;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import dov.com.qq.im.capture.poi.FacePoiSearchUI;
import dov.com.tencent.biz.qqstory.takevideo.poilist.QQStoryPoiListAdapter;
import java.util.ArrayList;
import java.util.List;

public class amxc
  implements LbsManager.POIListRequestCallback
{
  public amxc(FacePoiSearchUI paramFacePoiSearchUI, String paramString) {}
  
  public void a(int paramInt, LbsManager.POIListRequestSession paramPOIListRequestSession, List paramList)
  {
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = paramPOIListRequestSession;
    if (paramInt == 0) {
      if (paramPOIListRequestSession.a()) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.d.setVisibility(0);
      this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.a(bool);
      if (this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.b()) {
        this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter != null)
      {
        this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.a(this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.notifyDataSetChanged();
        if (this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.d.setVisibility(4);
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
 * Qualified Name:     amxc
 * JD-Core Version:    0.7.0.1
 */