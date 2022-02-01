import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.14.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.14.2;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import java.util.Map;
import mqq.os.MqqHandler;

public class bmhx
  implements INetEngine.INetEngineListener
{
  public bmhx(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt1, AEEditorFilterBean paramAEEditorFilterBean, int paramInt2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, null);
    if (AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment) == null) {}
    while (AEEditorImageEditFragment.b(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment)) {
      return;
    }
    if (paramNetResp.mRespData != null)
    {
      paramNetResp = AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, this.jdField_a_of_type_Int, paramNetResp.mRespData, paramNetResp.reqCost, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
      if (!TextUtils.isEmpty(paramNetResp))
      {
        paramNetResp = new bmgo(paramNetResp);
        AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment).put(AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean), paramNetResp);
        AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, this.jdField_a_of_type_Int, paramNetResp, this.b, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
        return;
      }
      bmbx.d("AEEditorImageEditFragment", "processComicResponse return path is empty");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.14.1(this));
      return;
    }
    bmbc.a().a(paramNetResp.mErrCode, paramNetResp.reqCost + "", "lut_comics", -2);
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.14.2(this));
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhx
 * JD-Core Version:    0.7.0.1
 */