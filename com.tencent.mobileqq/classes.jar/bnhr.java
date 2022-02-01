import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.ttpic.baseutils.string.StringUtils;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import dov.com.qq.im.ae.camera.ui.poi.AESelectLocationFragment;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditView;
import java.util.List;

public class bnhr
  extends bnqb
{
  private static boolean jdField_a_of_type_Boolean;
  private WatermarkEditView jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView;
  private String jdField_a_of_type_JavaLangString;
  private boolean b;
  
  public bnhr(Activity paramActivity, View paramView, bnqc parambnqc)
  {
    super(paramActivity, paramView, parambnqc);
  }
  
  private void a()
  {
    Object localObject = LogicDataManager.getInstance().getEditableWMElement();
    if ((localObject != null) && (((List)localObject).size() == 1) && (((List)localObject).get(0) != null))
    {
      localObject = (WMElement)((List)localObject).get(0);
      bnrh.a("AEWaterMarkEditorPart", "only jump to poi");
      if (("[location]".equals(((WMElement)localObject).fmtstr)) || ("[City]".equals(((WMElement)localObject).fmtstr)))
      {
        AESelectLocationFragment.a(this.mActivity, 203);
        this.jdField_a_of_type_JavaLangString = ((WMElement)localObject).sid;
        this.b = true;
      }
    }
    do
    {
      return;
      this.b = false;
      if (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView == null)
      {
        localObject = (ViewStub)this.mActivity.findViewById(2131364249);
        if (localObject != null)
        {
          ((ViewStub)localObject).inflate();
          this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView = ((WatermarkEditView)this.mActivity.findViewById(2131364248));
          this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.a(this.mActivity, this.mPartManager);
        }
      }
    } while (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView == null);
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.a();
  }
  
  public Object get(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(jdField_a_of_type_Boolean);
  }
  
  protected void initView() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 203) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("key_select_poi");
      bnrh.a("AEWaterMarkEditorPart", "onActivityResult" + paramIntent);
      if ((this.b) || (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView == null)) {
        break label73;
      }
      this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.setWaterMarkLocation(paramIntent);
    }
    label73:
    do
    {
      do
      {
        return;
      } while (!this.b);
      paramIntent = StringUtils.removeUTF8Emoji(paramIntent).trim();
      LogicDataManager.getInstance().setLocation(paramIntent);
    } while (this.jdField_a_of_type_JavaLangString == null);
    LogicDataManager.getInstance().recordLocationForSpecificMaterial(this.jdField_a_of_type_JavaLangString, paramIntent);
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 589825: 
      a();
      if (this.b)
      {
        jdField_a_of_type_Boolean = false;
        return;
      }
      jdField_a_of_type_Boolean = true;
      return;
    }
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView != null) && (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.getVisibility() == 0)) {
      this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.setVisibility(8);
    }
    jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhr
 * JD-Core Version:    0.7.0.1
 */