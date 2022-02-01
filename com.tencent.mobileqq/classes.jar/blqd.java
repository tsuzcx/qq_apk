import android.util.SparseArray;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedDisplayInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchUI;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import cooperation.qqreader.view.ReaderTabBarView;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class blqd
{
  public int a;
  RedTouchUI jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI;
  public String a;
  public boolean a;
  public int b = 0;
  
  public blqd(ReaderTabBarView paramReaderTabBarView, int paramInt1, String paramString, boolean paramBoolean, int paramInt2, RedTouchUI paramRedTouchUI)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI = paramRedTouchUI;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (ReaderTabBarView.a(this.jdField_a_of_type_CooperationQqreaderViewReaderTabBarView).get(paramInt) == null) {}
    label165:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Boolean = paramBoolean;
        if ((!this.jdField_a_of_type_Boolean) && (ReaderTabBarView.a(this.jdField_a_of_type_CooperationQqreaderViewReaderTabBarView).containsKey(Integer.valueOf(paramInt)))) {
          ReaderTabBarView.a(this.jdField_a_of_type_CooperationQqreaderViewReaderTabBarView).remove(Integer.valueOf(paramInt));
        }
        switch (this.jdField_a_of_type_Int)
        {
        default: 
          paramInt = 0;
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Boolean) {
            break label165;
          }
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI.d();
          return;
          paramInt = 0;
          continue;
          paramInt = -1;
          try
          {
            int i = Integer.parseInt(this.jdField_a_of_type_JavaLangString);
            paramInt = i;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              blpu.a("ReaderTabBarView", localNumberFormatException.getMessage());
              continue;
              paramBoolean = false;
            }
          }
          if (this.jdField_a_of_type_Boolean)
          {
            if (paramInt <= 0) {
              break;
            }
            paramBoolean = true;
            this.jdField_a_of_type_Boolean = paramBoolean;
          }
          paramInt = 4;
        }
        RedAppInfo localRedAppInfo = new RedAppInfo();
        localRedAppInfo.b(1);
        localRedAppInfo.c(paramInt);
        RedDisplayInfo localRedDisplayInfo = new RedDisplayInfo();
        RedTypeInfo localRedTypeInfo = new RedTypeInfo();
        localRedTypeInfo.setRedType(paramInt);
        Object localObject;
        if (paramInt == 4) {
          localObject = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject).put("cn", "#FF0000");
          localRedTypeInfo.setRedDesc(((JSONObject)localObject).toString());
          localRedTypeInfo.setRedContent(this.jdField_a_of_type_JavaLangString);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(localRedTypeInfo);
          localRedDisplayInfo.a((ArrayList)localObject);
          localRedAppInfo.a(localRedDisplayInfo);
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI.a(localRedAppInfo);
          if (localRedTypeInfo.getRedType() != 0) {
            break;
          }
          if (ReaderTabBarView.b(this.jdField_a_of_type_CooperationQqreaderViewReaderTabBarView) == 4)
          {
            this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI.a(0, 20, 8, 0).a();
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            blpu.a("ReaderTabBarView", localJSONException.getMessage());
          }
        }
      } while (ReaderTabBarView.b(this.jdField_a_of_type_CooperationQqreaderViewReaderTabBarView) != 5);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI.a(0, 15, 8, 0).a();
      return;
      if (ReaderTabBarView.b(this.jdField_a_of_type_CooperationQqreaderViewReaderTabBarView) == 4)
      {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI.a(0, 30, 2, 0).a();
        return;
      }
    } while (ReaderTabBarView.b(this.jdField_a_of_type_CooperationQqreaderViewReaderTabBarView) != 5);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI.a(0, 25, 2, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqd
 * JD-Core Version:    0.7.0.1
 */