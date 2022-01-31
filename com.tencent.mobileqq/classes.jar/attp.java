import android.graphics.Color;
import com.google.gson.Gson;
import com.tencent.lbssearch.httpresponse.HttpResponseListener;
import com.tencent.lbssearch.object.result.DrivingResultObject;
import com.tencent.lbssearch.object.result.DrivingResultObject.Result;
import com.tencent.lbssearch.object.result.DrivingResultObject.Route;
import com.tencent.lbssearch.object.result.TransitResultObject;
import com.tencent.lbssearch.object.result.TransitResultObject.Line;
import com.tencent.lbssearch.object.result.TransitResultObject.Result;
import com.tencent.lbssearch.object.result.TransitResultObject.Route;
import com.tencent.lbssearch.object.result.TransitResultObject.Segment;
import com.tencent.lbssearch.object.result.TransitResultObject.Transit;
import com.tencent.lbssearch.object.result.TransitResultObject.Walking;
import com.tencent.lbssearch.object.result.WalkingResultObject;
import com.tencent.lbssearch.object.result.WalkingResultObject.Result;
import com.tencent.lbssearch.object.result.WalkingResultObject.Route;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class attp
  implements HttpResponseListener
{
  public attp(MapWidget paramMapWidget, int paramInt, attu paramattu) {}
  
  public void onFailure(int paramInt, String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        paramThrowable.printStackTrace();
      }
      QLog.d("MapWidget", 2, "[map][venue][route]getRoutePlan onFailure invoked. error code: " + paramInt + " msg: " + paramString);
    }
    if (MapWidget.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget) != null) {
      MapWidget.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget).a(false, this.jdField_a_of_type_Attu);
    }
  }
  
  public void onSuccess(int paramInt, Object paramObject)
  {
    Object localObject1 = new Gson().toJson(paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("MapWidget", 2, "[map][venue][route]getRoutePlan onSuccess invoked. routeType: " + this.jdField_a_of_type_Int + " result: " + (String)localObject1);
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      paramObject = null;
    }
    label90:
    label739:
    label744:
    for (;;)
    {
      if (paramObject != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline != null) {
          this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.c(false);
        }
        if (bibv.a())
        {
          paramInt = Color.parseColor("#0071FF");
          label124:
          this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addPolyline(new PolylineOptions().addAll(paramObject).color(paramInt).width(bdaq.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.getContext(), 5.0F)));
          if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a();
            if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.jdField_a_of_type_Int == 0) {
              MapWidget.b(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget);
            }
          }
          if (MapWidget.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget) != null)
          {
            localObject1 = MapWidget.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget);
            if ((paramObject == null) || (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline == null)) {
              break label739;
            }
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ((attt)localObject1).a(bool, this.jdField_a_of_type_Attu);
        return;
        paramObject = (DrivingResultObject)paramObject;
        if ((paramObject.result == null) || (paramObject.result.routes == null) || (paramObject.result.routes.isEmpty()))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MapWidget", 2, "[map][venue][route]getRoutePlan onSuccess invoked. error ROUTE_TYPE_DRIVE");
          paramObject = null;
          break label90;
        }
        paramObject = (DrivingResultObject.Route)paramObject.result.routes.get(0);
        this.jdField_a_of_type_Attu.a = paramObject.duration;
        this.jdField_a_of_type_Attu.b = paramObject.distance;
        paramObject = paramObject.polyline;
        break label90;
        localObject1 = (TransitResultObject)paramObject;
        if ((((TransitResultObject)localObject1).result == null) || (((TransitResultObject)localObject1).result.routes == null) || (((TransitResultObject)localObject1).result.routes.isEmpty()))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MapWidget", 2, "[map][venue][route]getRoutePlan onSuccess invoked. error ROUTE_TYPE_BUS");
          paramObject = null;
          break label90;
        }
        paramObject = new ArrayList();
        localObject1 = (TransitResultObject.Route)((TransitResultObject)localObject1).result.routes.get(0);
        Iterator localIterator = ((TransitResultObject.Route)localObject1).steps.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (TransitResultObject.Segment)localIterator.next();
          if ((localObject2 instanceof TransitResultObject.Walking))
          {
            paramObject.addAll(((TransitResultObject.Walking)localObject2).polyline);
          }
          else if ((localObject2 instanceof TransitResultObject.Transit))
          {
            localObject2 = (TransitResultObject.Transit)localObject2;
            if ((((TransitResultObject.Transit)localObject2).lines != null) && (!((TransitResultObject.Transit)localObject2).lines.isEmpty())) {
              paramObject.addAll(((TransitResultObject.Line)((TransitResultObject.Transit)localObject2).lines.get(0)).polyline);
            }
          }
        }
        this.jdField_a_of_type_Attu.a = ((float)((TransitResultObject.Route)localObject1).duration);
        this.jdField_a_of_type_Attu.b = ((TransitResultObject.Route)localObject1).distance;
        if (!paramObject.isEmpty()) {
          break label744;
        }
        paramObject = null;
        break label90;
        paramObject = (WalkingResultObject)paramObject;
        if ((paramObject == null) || (paramObject.result == null) || (paramObject.result.routes == null) || (paramObject.result.routes.isEmpty()))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MapWidget", 2, "[map][venue][route]getRoutePlan onSuccess invoked. error ROUTE_TYPE_WALK");
          paramObject = null;
          break label90;
        }
        paramObject = (WalkingResultObject.Route)paramObject.result.routes.get(0);
        this.jdField_a_of_type_Attu.a = paramObject.duration;
        this.jdField_a_of_type_Attu.b = paramObject.distance;
        paramObject = paramObject.polyline;
        break label90;
        paramInt = Color.parseColor("#4D94FF");
        break label124;
        if (!QLog.isColorLevel()) {
          break label206;
        }
        QLog.d("MapWidget", 2, "[map][venue][route]getRoutePlan onSuccess invoked. error polyline: null");
        break label206;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     attp
 * JD-Core Version:    0.7.0.1
 */