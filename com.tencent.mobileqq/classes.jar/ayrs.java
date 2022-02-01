import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.lbssearch.object.param.Geo2AddressParam.PoiOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class ayrs
  extends ayrp
{
  private TencentSearch a;
  
  ayrs(String paramString)
  {
    super(paramString);
    jdField_a_of_type_JavaLangString = "NetworkLoader";
    this.jdField_a_of_type_ComTencentLbssearchTencentSearch = new TencentSearch(BaseApplicationImpl.getContext());
  }
  
  public boolean a(LatLng paramLatLng, int paramInt, ayry paramayry)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] netGet. latLng: " + paramLatLng);
    }
    this.jdField_a_of_type_ComTencentLbssearchTencentSearch.geo2address(new Geo2AddressParam(paramLatLng).getPoi(true).setPoiOptions(new Geo2AddressParam.PoiOptions().setPolicy(1).setPageSize(ayqi.d).setPageIndex(0)), new ayrt(this, paramLatLng, paramayry));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrs
 * JD-Core Version:    0.7.0.1
 */