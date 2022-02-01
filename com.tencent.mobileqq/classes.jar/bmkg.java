import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.ExportListener;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.aeeditor.module.export.AEEditorGenerateRunnable;

public class bmkg
  implements MovieExporter.ExportListener
{
  private long jdField_a_of_type_Long;
  private long b;
  
  public bmkg(AEEditorGenerateRunnable paramAEEditorGenerateRunnable, TAVCutVideoSession paramTAVCutVideoSession) {}
  
  public void onExportCancel()
  {
    bmbx.b("AEEditorGenerateRunnable", "onExportCancel:" + AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onExportCompleted(String paramString)
  {
    this.b = System.currentTimeMillis();
    bmbx.b("AEEditorGenerateRunnable", "perf: video export cost = " + (this.b - this.jdField_a_of_type_Long) + "ms");
    bmbx.b("AEEditorGenerateRunnable", "onExportCompleted mMissionID: " + AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    bmbx.b("AEEditorGenerateRunnable", "onExportCompleted exportPath: " + paramString);
    if (AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable).a(AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable), paramString);
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onExportError(AssetExportSession paramAssetExportSession)
  {
    int i = -1;
    if (paramAssetExportSession != null)
    {
      i = paramAssetExportSession.getErrCode();
      bmbx.d("AEEditorGenerateRunnable", "[onExportError] errorcode " + i);
    }
    bmbx.b("AEEditorGenerateRunnable", "onExportError:" + AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    if (AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable).a(AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable), i);
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onExportStart()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    bmbx.b("AEEditorGenerateRunnable", "onExportStart :" + AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    if (AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable).b(AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    }
  }
  
  public void onExporting(float paramFloat)
  {
    if (AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable).a(AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable), paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkg
 * JD-Core Version:    0.7.0.1
 */