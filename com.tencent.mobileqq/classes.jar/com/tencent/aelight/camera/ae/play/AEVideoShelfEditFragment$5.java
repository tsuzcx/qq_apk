package com.tencent.aelight.camera.ae.play;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.ShelfNode;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import java.util.ArrayList;
import java.util.List;

class AEVideoShelfEditFragment$5
  extends AsyncTask<Void, Void, Void>
{
  AEVideoShelfEditFragment$5(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    long l1 = System.currentTimeMillis();
    AEVideoShelfEditFragment.access$500(this.this$0);
    long l2 = System.currentTimeMillis();
    if (QLog.isDebugVersion()) {
      QLog.d("AEVideoShelfEditFrag", 2, new Object[] { "init data doInBackground1---cost: ", Long.valueOf(l2 - l1) });
    }
    AEVideoShelfEditFragment.access$600(this.this$0);
    if (QLog.isDebugVersion()) {
      QLog.d("AEVideoShelfEditFrag", 2, new Object[] { "init data doInBackground2---cost: ", Long.valueOf(System.currentTimeMillis() - l2) });
    }
    return null;
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    AEVideoShelfEditFragment.access$800(this.this$0);
    if (AEVideoShelfEditFragment.access$900(this.this$0).isEmpty())
    {
      AEQLog.c("AEVideoShelfEditFrag", "init NodeGroup Error!");
      return;
    }
    paramVoid = new ArrayList();
    int i = 0;
    while (i < AEVideoShelfEditFragment.access$900(this.this$0).size())
    {
      localObject = new ShelfNode();
      ((ShelfNode)localObject).setCoverUri(((NodeGroup)AEVideoShelfEditFragment.access$900(this.this$0).get(i)).nodeCoverImage);
      paramVoid.add(localObject);
      i += 1;
    }
    Object localObject = this.this$0;
    AEVideoShelfEditFragment.access$1002((AEVideoShelfEditFragment)localObject, new VideoListAdapter(((AEVideoShelfEditFragment)localObject).getBaseActivity(), paramVoid, AEVideoShelfEditFragment.access$100(this.this$0).getVideoWidth(), AEVideoShelfEditFragment.access$100(this.this$0).getVideoHeight()));
    AEVideoShelfEditFragment.access$1000(this.this$0).setMaterialPath(AEVideoShelfEditFragment.access$100(this.this$0).getMaterialPath());
    AEVideoShelfEditFragment.access$1100(this.this$0).setAdapter(AEVideoShelfEditFragment.access$1000(this.this$0));
    AEVideoShelfEditFragment.access$1200(this.this$0);
    AEVideoShelfEditFragment.access$1300(this.this$0);
    AEVideoShelfEditFragment.access$1400(this.this$0, 0);
    new AEVideoShelfEditFragment.OffscreenCaptureRunnable(this.this$0, null).run();
  }
  
  protected void onPreExecute()
  {
    AEVideoShelfEditFragment.access$700(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.5
 * JD-Core Version:    0.7.0.1
 */