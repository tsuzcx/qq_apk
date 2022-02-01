package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public class Task
{
  public static int STATUS_ACCEPT;
  public static int STATUS_FAIL;
  public static int STATUS_INIT = 1;
  public static int STATUS_QUIT;
  public static int STATUS_READY;
  public static int STATUS_STOP;
  public static int TYPE_CHECK = 4;
  public static int TYPE_DISTRIBUTION;
  public static int TYPE_EXTRACTION;
  public static int TYPE_FILTER;
  public static int TYPE_PROCESS;
  public ArrayList<Task.ConfigItem> check = new ArrayList();
  public JSONObject config;
  public ArrayList<Task.ConfigItem> distribution = new ArrayList();
  public ArrayList<Task.ConfigItem> extraction = new ArrayList();
  public ArrayList<Task.ConfigItem> filter = new ArrayList();
  public String id;
  public JSContext jsContext;
  public ArrayList<Task.ConfigItem> process = new ArrayList();
  public int status = STATUS_READY;
  
  static
  {
    STATUS_ACCEPT = 2;
    STATUS_STOP = 3;
    STATUS_QUIT = 4;
    STATUS_FAIL = 5;
    TYPE_EXTRACTION = 1;
    TYPE_PROCESS = 2;
    TYPE_DISTRIBUTION = 3;
  }
  
  public String toString()
  {
    return "Task{jsContext=" + this.jsContext + ", id='" + this.id + '\'' + ", status=" + this.status + ", config=" + this.config + ", filter=" + Arrays.toString(this.filter.toArray()) + ", extraction=" + Arrays.toString(this.extraction.toArray()) + ", process=" + Arrays.toString(this.process.toArray()) + ", distribution=" + Arrays.toString(this.distribution.toArray()) + ", check=" + Arrays.toString(this.check.toArray()) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.Task
 * JD-Core Version:    0.7.0.1
 */