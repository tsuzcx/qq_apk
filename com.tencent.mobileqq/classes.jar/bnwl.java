import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bnwl
  extends AsyncTask<Void, Void, Void>
{
  public bnwl(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = new Intent();
    paramVarArgs.putExtra("from", true);
    paramVarArgs.putExtra("isNeedEditButton", true);
    paramVarArgs.putExtra("usePagPreview", true);
    paramVarArgs.putExtra("videoOutWidth", AEVideoShelfEditFragment.a(this.a).getVideoWidth());
    paramVarArgs.putExtra("videoOutHeight", AEVideoShelfEditFragment.a(this.a).getVideoHeight());
    paramVarArgs.putExtra("pagFilePath", AEVideoShelfEditFragment.a(this.a).getPagFilePath());
    paramVarArgs.putExtra("audioFilePath", AEVideoShelfEditFragment.a(this.a).getAudioPath());
    paramVarArgs.putExtra("MaterialPath", AEVideoShelfEditFragment.a(this.a));
    paramVarArgs.putExtra("MaterialId", AEVideoShelfEditFragment.b(this.a));
    paramVarArgs.putExtra("MaterialName", AEVideoShelfEditFragment.a(this.a).getVideoName());
    paramVarArgs.putStringArrayListExtra("PhotoList", AEVideoShelfEditFragment.a(this.a));
    paramVarArgs.putExtra("loc_play_show_tab_name", AEVideoShelfEditFragment.c(this.a));
    paramVarArgs.putExtra("loc_play_show_material_id", AEVideoShelfEditFragment.b(this.a));
    paramVarArgs.putExtra("loc_play_show_take_same_name", AEVideoShelfEditFragment.d(this.a));
    paramVarArgs.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.a(this.a.getActivity()));
    HashMap localHashMap = new HashMap();
    Object localObject = AEVideoShelfEditFragment.a(this.a).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Iterator localIterator = ((NodeGroup)((Iterator)localObject).next()).nodeItemList.iterator();
      while (localIterator.hasNext())
      {
        NodeItem localNodeItem = (NodeItem)localIterator.next();
        if (localNodeItem.type != 1) {
          localHashMap.put(AEVideoShelfEditFragment.a(this.a, localNodeItem.nodeID, localNodeItem.cropBitmap), localNodeItem.indexLayerForPag);
        } else {
          localHashMap.put(AEVideoShelfEditFragment.a(this.a, localNodeItem.nodeID, localNodeItem.bitmap), localNodeItem.indexLayerForPag);
        }
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putSerializable("nodeImgList", localHashMap);
    paramVarArgs.putExtras((Bundle)localObject);
    AEVideoShelfEditFragment.a(this.a, paramVarArgs);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    AEVideoShelfEditFragment.c(this.a);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    AEVideoShelfEditFragment.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnwl
 * JD-Core Version:    0.7.0.1
 */