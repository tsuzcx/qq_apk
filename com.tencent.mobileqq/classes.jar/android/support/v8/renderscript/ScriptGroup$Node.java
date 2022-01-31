package android.support.v8.renderscript;

import java.util.ArrayList;

class ScriptGroup$Node
{
  int dagNumber;
  ArrayList<ScriptGroup.ConnectLine> mInputs = new ArrayList();
  ArrayList<Script.KernelID> mKernels = new ArrayList();
  Node mNext;
  ArrayList<ScriptGroup.ConnectLine> mOutputs = new ArrayList();
  Script mScript;
  
  ScriptGroup$Node(Script paramScript)
  {
    this.mScript = paramScript;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptGroup.Node
 * JD-Core Version:    0.7.0.1
 */