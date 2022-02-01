import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.ExportListener;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.aeeditor.module.export.AEEditorGenerateRunnable;

public class bphk
  implements MovieExporter.ExportListener
{
  private long jdField_a_of_type_Long;
  private long b;
  
  public bphk(AEEditorGenerateRunnable paramAEEditorGenerateRunnable, TAVCutVideoSession paramTAVCutVideoSession) {}
  
  public void onExportCancel()
  {
    bpam.b("AEEditorGenerateRunnable", "onExportCancel:" + AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onExportCompleted(String paramString)
  {
    this.b = System.currentTimeMillis();
    bpam.b("AEEditorGenerateRunnable", "perf: video export cost = " + (this.b - this.jdField_a_of_type_Long) + "ms");
    bpam.b("AEEditorGenerateRunnable", "onExportCompleted mMissionID: " + AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    bpam.b("AEEditorGenerateRunnable", "onExportCompleted exportPath: " + paramString);
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
      bpam.d("AEEditorGenerateRunnable", "[onExportError] errorcode " + i);
    }
    bpam.b("AEEditorGenerateRunnable", "onExportError:" + AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    if (AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable).a(AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable), i);
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onExportStart()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    bpam.b("AEEditorGenerateRunnable", "onExportStart :" + AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    if (AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable).d(AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
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
 * Qualified Name:     bphk
 * JD-Core Version:    0.7.0.1
 */