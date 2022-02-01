package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.BaseObject;
import java.util.List;

public class SuggestionResultObject
  extends BaseObject
{
  public int count;
  public List<SuggestionResultObject.SuggestionData> data;
  public List<SuggestionResultObject.SubPoi> sub_pois;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.SuggestionResultObject
 * JD-Core Version:    0.7.0.1
 */